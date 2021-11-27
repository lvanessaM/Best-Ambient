import { Usuarios } from 'src/app/model/usuarios';
export class Publicaciones {
  Titulo: string;
  Descripcion: string;
  estado!: boolean;
  fecha: Date;
  Usuario: Usuarios[];
}
