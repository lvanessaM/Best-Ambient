import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reuniones } from '../model/reuniones';

const baseUrl = 'http://localhost:8080/api/v1/reuniones';
let headers;
@Injectable({
  providedIn: 'root',
})
export class ReunionesService {
  constructor(private http: HttpClient) {
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(username + ':' + password),
    });
  }

  getAll(): Observable<Reuniones[]> {
    return this.http.get<Reuniones[]>(baseUrl, { headers });
  }

  get(id: String): Observable<Reuniones> {
    return this.http.get<Reuniones>(`${baseUrl}/${id}`, { headers });
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
