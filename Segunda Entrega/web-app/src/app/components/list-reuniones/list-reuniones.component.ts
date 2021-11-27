import { Component, OnInit } from '@angular/core';
import { Reuniones } from 'src/app/model/reuniones';
import { ReunionesService } from 'src/app/service/reuniones.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-list-reuniones',
  templateUrl: './list-reuniones.component.html',
  styleUrls: ['./list-reuniones.component.css']
})
export class ListReunionesComponent implements OnInit {
  reunionesSet!: Reuniones[];
  reunionesFil!: Reuniones[];
  currentReunion: Reuniones;
  idreuniones: number;
  P1!: number;
  P2!: number;
  collectionSize!: number;
  searchTerm!: string;
  closeModal!: string;
  msgError = '';
  currentReuniones: any;
  currentIndex = -1;
  constructor(
    private reunionesService: ReunionesService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
  }
  triggerModal(content: any, val: Reuniones) {
    this.currentReuniones = val;
    this.retrieveReunion(this.currentReuniones.id);
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (res) => {
          this.closeModal = `Closed with: ${res}`;
        },
        (res) => {
          this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
        }
      );
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  search(value: string): void {
    this.reunionesFil = this.reunionesSet.filter((val) =>
      val.lugar_encuentro.toLowerCase().includes(value)
    );
    this.collectionSize = this.reunionesFil.length;
  }

  retrievePublicaciones(): void {
    this.reunionesService.getAll().subscribe(
      (data) => {
        this.reunionesSet = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  retrieveReunion(val: number): void {
    this.reunionesService.get(val).subscribe(
      (data) => {
        this.currentReuniones = data;
        console.log(data);
      },
      (error) => {
        this.msgError = error.message + ' \n ' + error.error.message;
        console.log(error);
      }
    );
  }

  updateReuniones(): void {
    this.reunionesService
      .update(this.currentReuniones.id, this.currentReuniones)
      .subscribe(
        (data) => {
          this.refreshList();
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
  }

  deletePublicacion(val1: number): void {
    this.reunionesService.delete(val1).subscribe(
      (data) => {
        this.refreshList();
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setActivePublicaciones(reuniones: Reuniones, index: number): void {
    this.currentReuniones = reuniones;
    this.currentIndex = index;
  }
  refreshList(): void {
    this.retrievePublicaciones();
  }
}
