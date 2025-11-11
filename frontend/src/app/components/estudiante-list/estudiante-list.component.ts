import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EstudianteService } from '../../services/estudiante.service';
import { Estudiante } from '../../models/estudiante.model';

@Component({
  selector: 'app-estudiante-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './estudiante-list.component.html',
  styleUrls: ['./estudiante-list.component.css']
})
export class EstudianteListComponent implements OnInit {
  estudiantes: Estudiante[] = [];
  nuevoEstudiante: Estudiante = {
    nombre: '',
    apellido: '',
    email: '',
    edad: undefined,
    carrera: ''
  };
  estudianteEditando: Estudiante | null = null;
  mostrarFormulario = false;
  modoEdicion = false;
  mensaje = '';
  tipoMensaje = '';

  constructor(private estudianteService: EstudianteService) { }

  ngOnInit(): void {
    this.cargarEstudiantes();
  }

  cargarEstudiantes(): void {
    this.estudianteService.getAllEstudiantes().subscribe({
      next: (response) => {
        this.estudiantes = response.data;
      },
      error: (error) => {
        this.mostrarMensaje('Error al cargar estudiantes', 'danger');
        console.error('Error:', error);
      }
    });
  }

  mostrarFormularioAgregar(): void {
    this.mostrarFormulario = true;
    this.modoEdicion = false;
    this.estudianteEditando = null;
    this.nuevoEstudiante = {
      nombre: '',
      apellido: '',
      email: '',
      edad: undefined,
      carrera: ''
    };
  }

  mostrarFormularioEditar(estudiante: Estudiante): void {
    this.mostrarFormulario = true;
    this.modoEdicion = true;
    this.estudianteEditando = { ...estudiante };
    this.nuevoEstudiante = { ...estudiante };
  }

  guardarEstudiante(): void {
    if (this.modoEdicion && this.estudianteEditando) {
      this.actualizarEstudiante();
    } else {
      this.crearEstudiante();
    }
  }

  crearEstudiante(): void {
    this.estudianteService.createEstudiante(this.nuevoEstudiante).subscribe({
      next: (response) => {
        this.mostrarMensaje(response.message, 'success');
        this.cargarEstudiantes();
        this.cancelarFormulario();
      },
      error: (error) => {
        this.mostrarMensaje('Error al crear estudiante', 'danger');
        console.error('Error:', error);
      }
    });
  }

  actualizarEstudiante(): void {
    if (this.estudianteEditando && this.estudianteEditando.id) {
      this.estudianteService.updateEstudiante(this.estudianteEditando.id, this.nuevoEstudiante).subscribe({
        next: (response) => {
          this.mostrarMensaje(response.message, 'success');
          this.cargarEstudiantes();
          this.cancelarFormulario();
        },
        error: (error) => {
          this.mostrarMensaje('Error al actualizar estudiante', 'danger');
          console.error('Error:', error);
        }
      });
    }
  }

  eliminarEstudiante(id: number): void {
    if (confirm('¿Estás seguro de que quieres eliminar este estudiante?')) {
      this.estudianteService.deleteEstudiante(id).subscribe({
        next: (response) => {
          this.mostrarMensaje(response.message, 'success');
          this.cargarEstudiantes();
        },
        error: (error) => {
          this.mostrarMensaje('Error al eliminar estudiante', 'danger');
          console.error('Error:', error);
        }
      });
    }
  }

  cancelarFormulario(): void {
    this.mostrarFormulario = false;
    this.modoEdicion = false;
    this.estudianteEditando = null;
    this.nuevoEstudiante = {
      nombre: '',
      apellido: '',
      email: '',
      edad: undefined,
      carrera: ''
    };
  }

  mostrarMensaje(mensaje: string, tipo: string): void {
    this.mensaje = mensaje;
    this.tipoMensaje = tipo;
    setTimeout(() => {
      this.mensaje = '';
      this.tipoMensaje = '';
    }, 3000);
  }

  esFormularioValido(): boolean {
    return this.nuevoEstudiante.nombre.trim() !== '' &&
           this.nuevoEstudiante.apellido.trim() !== '' &&
           this.nuevoEstudiante.email.trim() !== '';
  }
}