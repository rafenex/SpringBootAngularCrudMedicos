import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthHelper } from '../_helpers/auth-helpers';

@Component({
  selector: 'app-cadastrar-medicos',
  templateUrl: './cadastrar-medicos.component.html',
  styleUrls: ['./cadastrar-medicos.component.css']
})
export class CadastrarMedicosComponent implements OnInit {
  mensagem = "";

  constructor(private httpClient: HttpClient, private authHelper: AuthHelper) { }

  ngOnInit(): void {
    if (!this.authHelper.isAuthenticated()) {
      window.alert("Acesso negado");
      window.location.href = "/";
    }

  }

  formCadastro = new FormGroup({
    nome: new FormControl('', [Validators.required]),
    crm: new FormControl('', [Validators.required]),
    telefone: new FormControl('', [Validators.required]),
    tipo: new FormControl('', [Validators.required]),
  })

  get form(): any {
    return this.formCadastro.controls;
  }

  onSubmit(): void {
    this.httpClient.post(
      environment.apiUrl + '/medicos',
      this.formCadastro.value,
      { responseType: 'text' })
      .subscribe(
        data => {
          this.mensagem = data;
          this.formCadastro.reset();
        },
        e => {
          this.mensagem = "Ocorreu um erro, o cadastro não foi realizado";
          console.log(e);
        }
      )


  }

}
