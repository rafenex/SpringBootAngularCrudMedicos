import { CadastrarMedicosComponent } from './cadastrar-medicos/cadastrar-medicos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'cadastrar-medicos', component: CadastrarMedicosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
