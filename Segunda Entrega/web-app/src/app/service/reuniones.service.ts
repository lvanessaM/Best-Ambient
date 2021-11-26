import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Reuniones} from '../model/reuniones'


const baseUrl = 'http://localhost:8080/api/v1/reuniones'

@Injectable({
  providedIn: 'root'
})

export class ReunionesService {

  constructor(private http: HttpClient) {}

    getAll(): Observable<Reuniones[]> {
      return this.http.get<Reuniones[]>(baseUrl);
    }
  
    get(id: String): Observable<Reuniones> {
      return this.http.get<Reuniones>(`${baseUrl}/${id}`);
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
