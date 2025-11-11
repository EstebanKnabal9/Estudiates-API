import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  template: `
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container">
        <a class="navbar-brand" href="#">
          <i class="fas fa-graduation-cap me-2"></i>
          Gestión de Estudiantes
        </a>
      </div>
    </nav>
    
    <div class="container mt-4">
      <router-outlet></router-outlet>
    </div>
  `,
  styles: [`
    .navbar-brand {
      font-weight: 600;
      font-size: 1.5rem;
    }
  `]
})
export class AppComponent {
  title = 'Gestión de Estudiantes';
}