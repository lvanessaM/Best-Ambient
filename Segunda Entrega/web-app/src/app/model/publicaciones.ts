import { Usuarios } from 'src/app/model/usuarios';
export class Publicaciones {
  id: number;
  titulo: string;
  descripcion: string;
  estado!: boolean;
  fecha: Date;
  Usuario: Usuarios[];
}
