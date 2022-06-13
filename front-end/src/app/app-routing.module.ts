import { ConsultarMedicosComponent } from './consultar-medicos/consultar-medicos.component';
import { CadastrarMedicosComponent } from './cadastrar-medicos/cadastrar-medicos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'cadastrar-medicos', component: CadastrarMedicosComponent },
  { path: 'consultar-medicos', component: ConsultarMedicosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
