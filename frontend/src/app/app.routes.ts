import { Routes } from '@angular/router';
import { EstudianteListComponent } from './components/estudiante-list/estudiante-list.component';

export const routes: Routes = [
  { path: '', redirectTo: '/estudiantes', pathMatch: 'full' },
  { path: 'estudiantes', component: EstudianteListComponent },
  { path: '**', redirectTo: '/estudiantes' }
];