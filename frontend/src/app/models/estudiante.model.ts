export interface Estudiante {
  id?: number;
  nombre: string;
  apellido: string;
  email: string;
  edad?: number;
  carrera?: string;
}

export interface ApiResponse<T> {
  data: T;
  httpStatus: string;
  message: string;
}