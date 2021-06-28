import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Embarcados } from './embarcados';

@Component({
  selector: 'app-embarcados',
  templateUrl: './embarcados.page.html',
  styleUrls: ['./embarcados.page.scss'],
})
export class EmbarcadosPage implements OnInit {
  private AUTH_SERVER_ADDRESS: string = 'http://localhost:7772/api/embarcados';

  obj: Embarcados = new Embarcados();

  constructor(private httpClient: HttpClient) { }

  ngOnInit() { }

  submit() {
    this.envia().subscribe(responseApi => {
      this.obj = new Embarcados();
    })
  }

  envia(): Observable<any> {
    return this.httpClient.post<any>(`${this.AUTH_SERVER_ADDRESS}`, this.obj).pipe(
      tap(async (responseApi) => { })
    );
  }
}
