import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { AuthHelper } from '../_helpers/auth-helpers';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  mensagem_sucesso = '';
  mensagem_erro = '';
  exibirPagina = false;

  constructor(private httpClient: HttpClient, private authHelper: AuthHelper) { }

  ngOnInit(): void {
    if (this.authHelper.isAuthenticated()) {
      //redirecionamento
      window.location.href = "/consultar-medicos";
    } else {
      this.exibirPagina = true;
    }
  }

  formLogin = new FormGroup({
    login: new FormControl('', [Validators.required]),
    senha: new FormControl('', [Validators.required]),
  })

  get form(): any {
    return this.formLogin.controls;
  }

  onSubmit(): void {
    this.mensagem_erro = '';
    this.exibirPagina = false;
    this.httpClient.post(
      environment.apiUrl + '/login',
      this.formLogin.value, { responseType: 'text' }).subscribe(
        data => {
          localStorage.setItem('access_token', data);
          localStorage.setItem('login_usuario', this.formLogin.value.login!);


          //redirecionamento
          window.location.href = "/consultar-medicos";

        },
        e => {
          this.mensagem_erro = e.error;
          console.log(e);
        }
      )

  }


}
