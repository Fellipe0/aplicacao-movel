import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Observable, BehaviorSubject } from 'rxjs';

import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private curUser: BehaviorSubject<User>;

  AUTH_SERVER_ADDRESS: string = 'http://localhost:7772/api/usuarios';
  authSubject = new BehaviorSubject(false);

  constructor(private httpClient: HttpClient) {
    const json = localStorage.getItem('jwt') != null ? atob(localStorage.getItem('jwt')) : null;
    this.curUser = new BehaviorSubject<User>(JSON.parse(json));
  }

  register(user: User): Observable<any> {
    return this.httpClient.post<any>(`${this.AUTH_SERVER_ADDRESS}`, user).pipe(
      tap(async (responseApi) => {
        if (responseApi.data != null) {
          await localStorage.setItem("jwt", btoa(JSON.stringify(responseApi.data)));
          this.curUser.next(responseApi.data);
          this.authSubject.next(true);
        }
      })

    );
  }

  login(user: User): Observable<any> {
    return this.httpClient.get(`${this.AUTH_SERVER_ADDRESS}/login?email=${user.email}&senha=${user.password}`).pipe(
      tap(async (responseApi) => {

        if (responseApi.data) {
          await localStorage.setItem("jwt", btoa(JSON.stringify(responseApi.data)));
          this.curUser.next(responseApi.data);
          this.authSubject.next(true);
        }
      })
    );
  }

  async logout() {
    await localStorage.removeItem("jwt");
    this.curUser.next(null);
    this.authSubject.next(false);
  }

  isLoggedIn() {
    return this.authSubject.asObservable();
  }

  public get currentUser() {
    return this.authResponse;
  }

  public get authResponse(): User {
    return this.curUser.value;
  }
}
