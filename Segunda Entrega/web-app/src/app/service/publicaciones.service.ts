import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Publicaciones } from '../model/publicaciones';

const baseUrl = 'http://localhost:8080/api/v1/publicaciones';
let username = localStorage.getItem('usenarme');
let password = localStorage.getItem('paswword');
const headers = new HttpHeaders({
  Authorization: 'Basic' + btoa(username + ':' + password),
});

@Injectable({
  providedIn: 'root',
})
export class PublicacionesService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Publicaciones[]> {
    return this.http.get<Publicaciones[]>(baseUrl, { headers });
  }

  get(id: String): Observable<Publicaciones> {
    return this.http.get<Publicaciones>(`${baseUrl}/${id}`, { headers });
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data, { headers });
  }

  update(id: string, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data, { headers });
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`, { headers });
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl, { headers });
  }
}
