package com.example.backend.projection;

/**
 * Proyección para optimizar consultas de estudiantes
 * Solo incluye los campos más importantes para listados
 */
public interface EstudianteProjection {
    Long getId();
    String getNombre();
    String getApellido();
    String getEmail();
    String getCarrera();
}