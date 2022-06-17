import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastrarMedicosComponent } from './cadastrar-medicos/cadastrar-medicos.component';
import { ConsultarMedicosComponent } from './consultar-medicos/consultar-medicos.component';
import { EditarMedicosComponent } from './editar-medicos/editar-medicos.component';
import { LoginComponent } from './login/login.component';
import { AccountComponent } from './account/account.component';
import { AuthHelper } from './_helpers/auth-helpers';
import { TokenInterceptor } from './_intercepters/tokenInterceptor';

@NgModule({
  declarations: [
    AppComponent,
    CadastrarMedicosComponent,
    ConsultarMedicosComponent,
    EditarMedicosComponent,
    LoginComponent,
    AccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      //Config do interceptor
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    {
      provide: AuthHelper
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
