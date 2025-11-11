package com.example.backend.repository;

import com.example.backend.model.Estudiante;
import com.example.backend.projection.EstudianteProjection;
import com.example.backend.projection.EstudianteResumenProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
    // Buscar por email (útil para validar unicidad)
    Optional<Estudiante> findByEmail(String email);
    
    // Buscar por carrera
    List<Estudiante> findByCarrera(String carrera);
    
    // Proyección completa para listados optimizados
    @Query("SELECT e.id as id, e.nombre as nombre, e.apellido as apellido, " +
           "e.email as email, e.carrera as carrera FROM Estudiante e")
    List<EstudianteProjection> findAllProjected();
    
    // Proyección de resumen para listados básicos
    @Query("SELECT e.id as id, e.nombre as nombre, e.apellido as apellido, " +
           "e.email as email FROM Estudiante e")
    List<EstudianteResumenProjection> findAllResumen();
    
    // Proyección por carrera
    @Query("SELECT e.id as id, e.nombre as nombre, e.apellido as apellido, " +
           "e.email as email, e.carrera as carrera FROM Estudiante e WHERE e.carrera = :carrera")
    List<EstudianteProjection> findByCarreraProjected(@Param("carrera") String carrera);
    
    // Buscar estudiantes por rango de edad
    List<Estudiante> findByEdadBetween(Integer edadMin, Integer edadMax);
    
    // Contar estudiantes por carrera
    @Query("SELECT COUNT(e) FROM Estudiante e WHERE e.carrera = :carrera")
    Long countByCarrera(@Param("carrera") String carrera);
}