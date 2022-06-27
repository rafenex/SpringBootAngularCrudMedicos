import { AuthHelper } from './../_helpers/auth-helpers';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-consultar-medicos',
  templateUrl: './consultar-medicos.component.html',
  styleUrls: ['./consultar-medicos.component.css']
})
export class ConsultarMedicosComponent implements OnInit {
  mensagem = "";

  medicos: any[] = [];

  constructor(private httpClient: HttpClient, private authHelper: AuthHelper) {

  }

  ngOnInit(): void {
    if (this.authHelper.isAuthenticated()) {
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
    } else {
      window.alert("Acesso negado");
      window.location.href = "/";
    }

  }

  formEditar = new FormGroup({
    idMedico: new FormControl('', []),
    nome: new FormControl('', [Validators.required]),
    crm: new FormControl('', [Validators.required]),
    telefone: new FormControl('', [Validators.required]),
    tipo: new FormControl('', [Validators.required]),
  })
  get form(): any {
    return this.formEditar.controls;
  }


  excluir(idMedico: number): void {
    if (window.confirm('Deseja realmente excluir o médico selecionado?')) {
      this.httpClient.delete(
        environment.apiUrl + '/medicos/' + idMedico,
        { responseType: 'text' })
        .subscribe(
          (data) => {
            alert(data);
            this.ngOnInit();
          },
          (e) => {
            console.log(e);
          }
        )

    }
  }

  relatorio(): void {
    this.httpClient.get(
      "http://localhost:8080/report/pdf",
      { responseType: 'text' })
      .subscribe(

        (data) => {
          alert(data);
          this.ngOnInit();
        },
        (e) => {
          console.log(e);
        }
      )
  }
}



