import { AuthHelper } from './../_helpers/auth-helpers';
import { HttpClient } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-editar-medicos',
  templateUrl: './editar-medicos.component.html',
  styleUrls: ['./editar-medicos.component.css']
})
export class EditarMedicosComponent implements OnInit {
  mensagem = "";

  constructor(private httpClient: HttpClient, private activeRoute: ActivatedRoute, private authHelper: AuthHelper) { }

  formEdicao = new FormGroup({
    idMedico: new FormControl('', []),
    nome: new FormControl('', [Validators.required]),
    crm: new FormControl('', [Validators.required]),
    telefone: new FormControl('', [Validators.required]),
    tipo: new FormControl('', [Validators.required]),
  })

  get form(): any {
    return this.formEdicao.controls;
  }
  onSubmit(): void {
    const idMedico = this.activeRoute.snapshot.paramMap.get('id') as string;
    this.httpClient.put(environment.apiUrl + "/medicos/" + idMedico, this.formEdicao.value,
      { responseType: 'text' })
      .subscribe(
        data => {
          this.mensagem = data;
        },
        e => {
          this.mensagem = "Ocorreu um erro, a edição não foi realizada."
          console.log(e);
        }
      )
  }

  ngOnInit(): void {
    if (this.authHelper.isAuthenticated()) {
      const idMedico = this.activeRoute.snapshot.paramMap.get('id') as string;

      this.httpClient.get(environment.apiUrl + "/medicos/" + idMedico)
        .subscribe(
          (data: any) => {
            this.formEdicao.patchValue(data);
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
}
