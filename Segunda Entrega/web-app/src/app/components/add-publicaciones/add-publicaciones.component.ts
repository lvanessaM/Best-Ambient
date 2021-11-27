import { Component, OnInit } from '@angular/core';
import { Publicaciones } from 'src/app/model/publicaciones';
import { PublicacionesService } from 'src/app/service/publicaciones.service';

@Component({
  selector: 'app-add-publicaciones',
  templateUrl: './add-publicaciones.component.html',
  styleUrls: ['./add-publicaciones.component.css'],
})
export class AddPublicacionesComponent implements OnInit {
  titulo: string;
  publicaciones = new Publicaciones();
  submitted = false;
  msgError = '';
  isDisabled = true;
  constructor(private PublicacionesService: PublicacionesService) {}

  ngOnInit(): void {}
  savePublicacion(): void {
    const data = {
      titulo: this.titulo,
      Descripcion: this.publicaciones.Descripcion,
      estado: this.publicaciones.estado,
      Date: this.publicaciones.Titulo,
    };
    this.PublicacionesService.create(data).subscribe(
      (data) => {
        this.submitted = true;
        console.log(data);
      },
      (err) => {
        this.msgError = err.error.message;
        console.log(err);
      }
    );
  }
}
