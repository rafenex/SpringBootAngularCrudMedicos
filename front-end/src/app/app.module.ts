import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastrarMedicosComponent } from './cadastrar-medicos/cadastrar-medicos.component';
import { ConsultarMedicosComponent } from './consultar-medicos/consultar-medicos.component';
import { EditarMedicosComponent } from './editar-medicos/editar-medicos.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastrarMedicosComponent,
    ConsultarMedicosComponent,
    EditarMedicosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
