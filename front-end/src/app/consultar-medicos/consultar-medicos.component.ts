import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consultar-medicos',
  templateUrl: './consultar-medicos.component.html',
  styleUrls: ['./consultar-medicos.component.css']
})
export class ConsultarMedicosComponent implements OnInit {
  mensagem = "";

  medicos: any[] = [];

  constructor(private httpClient: HttpClient) {
    this.httpClient.get(
      environment.apiUrl + '/medicos')
      .subscribe(
        (data) => {
          this.medicos = data as any[];
        },
        (e) => {
          console.log(e);
        }
      )
  }

  ngOnInit(): void {
  }

}
