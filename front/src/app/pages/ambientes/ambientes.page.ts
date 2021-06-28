import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Ambiente } from './ambientes';

@Component({
  selector: 'app-ambientes',
  templateUrl: './ambientes.page.html',
  styleUrls: ['./ambientes.page.scss'],
})
export class AmbientesPage implements OnInit {
  private AUTH_SERVER_ADDRESS: string = 'http://localhost:7772/api/ambientes';
  obj: Ambiente = new Ambiente();

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
  }

  submit() {
    this.envia().subscribe(responseApi=>{
      if(responseApi.data != null){
        this.obj = new Ambiente();
      }
    })
  }

  envia(): Observable<any> {
    return this.httpClient.post<any>(`${this.AUTH_SERVER_ADDRESS}`, this.obj).pipe(
      tap(async (responseApi) => {})
    );
  }
}
