import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Publicaciones } from '../model/publicaciones';

const baseUrl = 'http://localhost:8080/api/v1/publicaciones';
let headers;

@Injectable({
  providedIn: 'root',
})
export class PublicacionesService {
  constructor(private http: HttpClient) {
    let username = sessionStorage.getItem('username');
    let password = sessionStorage.getItem('password');
    headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(username + ':' + password),
    });
  }
  getAll(): Observable<Publicaciones[]> {
    return this.http.get<Publicaciones[]>(baseUrl, { headers });
  }

  get(id: number): Observable<Publicaciones> {
    return this.http.get<Publicaciones>(`${baseUrl}/${id}`, { headers });
  }

  create(data: any): Observable<any> {
    console.log(headers);
    return this.http.post(baseUrl, data, { headers });
  }

  update(id: number, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data, { headers });
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`, { headers });
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl, { headers });
  }
}
