import { Component, OnInit } from '@angular/core';
import { Publicaciones } from 'src/app/model/publicaciones';
import { PublicacionesService } from 'src/app/service/publicaciones.service';
import { ModalDismissReasons, NgbModal} from  '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-list-publicaciones',
  templateUrl: './list-publicaciones.component.html',
  styleUrls: ['./list-publicaciones.component.css']
})
export class ListPublicacionesComponent implements OnInit {
  publicacionesSet!: Publicaciones[];
  publicacionesFil!: Publicaciones[];
  idpublicaciones!: string;
  P1!: number;
  P2!: number;
  collectionSize!: number;
  searchTerm!: string;
  closeModal!: string;
  msgError = '';
  currentPublicaciones: any;
  currentIndex = -1;


  constructor(
    private publicacionesService: PublicacionesService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.refreshList();
  }
  triggerModal(content: any, val: Publicaciones) {
    this.currentPublicaciones = val;
    this.retrievePublicacion(this.currentPublicaciones.id);
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
    this.publicacionesFil = this.publicacionesSet.filter((val) =>
      val.Titulo.toLowerCase().includes(value)
    );
    this.collectionSize = this.publicacionesFil.length;
  }

  retrievePublicaciones(): void {
    this.publicacionesService.getAll().subscribe(
      (data) => {
        this.publicacionesSet = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  retrievePublicacion(val: string): void {
    this.publicacionesService.get(val).subscribe(
      (data) => {
        this.currentPublicaciones = data;
        console.log(data);
      },
      (error) => {
        this.msgError = error.message + ' \n ' + error.error.message;
        console.log(error);
      }
    );
  }

  updatePublicaciones(): void {
    this.publicacionesService.update(this.currentPublicaciones.id, this.currentPublicaciones).subscribe(
      (data) => {
        this.refreshList();
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  deletePublicacion(val1: string): void {
    this.publicacionesService.delete(val1).subscribe(
      (data) => {
        this.refreshList();
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setActivePublicaciones(publicaciones: Publicaciones, index: number): void {
    this.currentPublicaciones = publicaciones;
    this.currentIndex = index;
  }
  refreshList(): void {
    this.retrievePublicaciones();
  }


}