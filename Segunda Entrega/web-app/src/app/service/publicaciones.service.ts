import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Publicaciones } from "../model/publicaciones"

const baseUrl='http://localhost:8080/api/v1/publicaciones'

@Injectable({
  providedIn: 'root'
})
export class PublicacionesService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Publicaciones[]> {
    return this.http.get<Publicaciones[]>(baseUrl);
  }

  get(id: String): Observable<Publicaciones> {
    return this.http.get<Publicaciones>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }


}
