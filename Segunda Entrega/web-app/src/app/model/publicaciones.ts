import {Usuarios}from 'src/app/model/usuarios'
export class Publicaciones {

    id!: number;
    Titulo!: string;
    Descripcion!:string;
    estado!:boolean;
    fecha!:Date;
    Usuario:Usuarios[];
}
