import { Component, OnInit } from '@angular/core';
import {Reuniones} from 'src/app/model/reuniones';
import {ReunionesService} from 'src/app/service/reuniones.service'

@Component({
  selector: 'app-add-reuniones',
  templateUrl: './add-reuniones.component.html',
  styleUrls: ['./add-reuniones.component.css']
})
export class AddReunionesComponent implements OnInit {
  reuniones = new Reuniones();
  submitted = false;
  msgError = '';
  isDisabled = true;
  constructor(private ReunionesService: ReunionesService) { }

  ngOnInit(): void {
  }
  saveReunion(): void {
    const data = {
      id!:this.reuniones.id,
      lugar_encuentro!:this.reuniones.lugar_encuentro,
      estado!:this.reuniones.estado,
      descripciom_actividad!:this.reuniones.descripciom_actividad

    };this.ReunionesService.create(data)
    .subscribe(
      data => {
        this.submitted=true;
        console.log(data);
      },
      err => {
        this.msgError  = err.error.message;
        console.log(err);
      });
}
}