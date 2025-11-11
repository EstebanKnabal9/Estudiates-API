package com.example.backend.projection;

/**
 * Proyección más simple para resúmenes o listados básicos
 */
public interface EstudianteResumenProjection {
    Long getId();
    String getNombre();
    String getApellido();
    String getEmail();
}