import { EditarMedicosComponent } from './editar-medicos/editar-medicos.component';
import { ConsultarMedicosComponent } from './consultar-medicos/consultar-medicos.component';
import { CadastrarMedicosComponent } from './cadastrar-medicos/cadastrar-medicos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: ConsultarMedicosComponent },
  { path: 'cadastrar-medicos', component: CadastrarMedicosComponent },
  { path: 'consultar-medicos', component: ConsultarMedicosComponent },
  { path: 'editar-medicos/:id', component: EditarMedicosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
