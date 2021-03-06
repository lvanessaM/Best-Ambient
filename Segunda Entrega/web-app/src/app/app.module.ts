import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPublicacionesComponent } from './components/add-publicaciones/add-publicaciones.component';
import { ListPublicacionesComponent } from './components/list-publicaciones/list-publicaciones.component';

import { ListFilterPipe } from './service/filter.service';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddReunionesComponent } from './components/add-reuniones/add-reuniones.component';

import { LoginComponent } from './components/login/login.component';
import { TipoproblemasComponent } from './components/tipoproblemas/tipoproblemas.component';
import { ListReunionesComponent } from './components/list-reuniones/list-reuniones.component';

@NgModule({
  declarations: [
    AppComponent,
    AddPublicacionesComponent,
    ListPublicacionesComponent,
    ListFilterPipe,
    AddReunionesComponent,

    LoginComponent,
    TipoproblemasComponent,
    ListReunionesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
