import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPublicacionesComponent } from './components/add-publicaciones/add-publicaciones.component';
import { ListPublicacionesComponent } from './components/list-publicaciones/list-publicaciones.component';
import { AddReunionesComponent } from './components/add-reuniones/add-reuniones.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', redirectTo: 'Publicaciones', pathMatch: 'full' },

  { path: 'inicio', component: InicioComponent },
  { path: 'add1', component: AddReunionesComponent },
  { path: 'list', component: ListPublicacionesComponent },
  { path: 'add', component: AddPublicacionesComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
