import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudiante, ApiResponse } from '../models/estudiante.model';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private apiUrl = 'http://localhost:8081/api/estudiantes';

  constructor(private http: HttpClient) { }

  getAllEstudiantes(): Observable<ApiResponse<Estudiante[]>> {
    return this.http.get<ApiResponse<Estudiante[]>>(this.apiUrl);
  }

  getEstudianteById(id: number): Observable<ApiResponse<Estudiante>> {
    return this.http.get<ApiResponse<Estudiante>>(`${this.apiUrl}/${id}`);
  }

  createEstudiante(estudiante: Estudiante): Observable<ApiResponse<Estudiante>> {
    return this.http.post<ApiResponse<Estudiante>>(this.apiUrl, estudiante);
  }

  updateEstudiante(id: number, estudiante: Estudiante): Observable<ApiResponse<Estudiante>> {
    return this.http.put<ApiResponse<Estudiante>>(`${this.apiUrl}/${id}`, estudiante);
  }

  deleteEstudiante(id: number): Observable<ApiResponse<void>> {
    return this.http.delete<ApiResponse<void>>(`${this.apiUrl}/${id}`);
  }
}