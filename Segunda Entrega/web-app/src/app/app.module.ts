import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPublicacionesComponent } from './components/add-publicaciones/add-publicaciones.component';
import { ListPublicacionesComponent } from './components/list-publicaciones/list-publicaciones.component';

@NgModule({
  declarations: [
    AppComponent,
    AddPublicacionesComponent,
    ListPublicacionesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
