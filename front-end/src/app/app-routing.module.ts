import { EditarMedicosComponent } from './editar-medicos/editar-medicos.component';
import { ConsultarMedicosComponent } from './consultar-medicos/consultar-medicos.component';
import { CadastrarMedicosComponent } from './cadastrar-medicos/cadastrar-medicos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AccountComponent } from './account/account.component';

const routes: Routes = [
  { path: 'cadastrar-medicos', component: CadastrarMedicosComponent },
  { path: 'consultar-medicos', component: ConsultarMedicosComponent },
  { path: 'editar-medicos/:id', component: EditarMedicosComponent },
  { path: '', component: LoginComponent },
  { path: 'account', component: AccountComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
