package com.example.backend.controller;

import com.example.backend.dto.ApiResponse;
import com.example.backend.dto.EstudianteDTO;
import com.example.backend.projection.EstudianteProjection;
import com.example.backend.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EstudianteDTO>>> getAllEstudiantes() {
        List<EstudianteDTO> estudiantes = estudianteService.getAllEstudiantesDTO();
        return ResponseEntity.ok(ApiResponse.success(estudiantes, "Estudiantes obtenidos exitosamente"));
    }
    
    @GetMapping("/projected")
    public ResponseEntity<ApiResponse<List<EstudianteProjection>>> getAllEstudiantesProjected() {
        List<EstudianteProjection> estudiantes = estudianteService.getAllEstudiantesProjected();
        return ResponseEntity.ok(ApiResponse.success(estudiantes, "Estudiantes obtenidos exitosamente"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EstudianteDTO>> getEstudianteById(@PathVariable Long id) {
        return estudianteService.getEstudianteDTOById(id)
                .map(estudiante -> ResponseEntity.ok(ApiResponse.success(estudiante, "Estudiante encontrado")))
                .orElse(ResponseEntity.status(404).body(ApiResponse.notFound("Estudiante no encontrado")));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EstudianteDTO>> createEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        if (estudianteService.existsByEmail(estudianteDTO.getEmail())) {
            return ResponseEntity.badRequest().body(ApiResponse.badRequest("Ya existe un estudiante con ese email"));
        }
        
        EstudianteDTO createdEstudiante = estudianteService.createEstudianteFromDTO(estudianteDTO);
        return ResponseEntity.status(201).body(ApiResponse.created(createdEstudiante, "Estudiante creado exitosamente"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EstudianteDTO>> updateEstudiante(
            @PathVariable Long id, 
            @RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.updateEstudiante(id, estudianteDTO)
                .map(estudiante -> ResponseEntity.ok(ApiResponse.success(estudiante, "Estudiante actualizado exitosamente")))
                .orElse(ResponseEntity.status(404).body(ApiResponse.notFound("Estudiante no encontrado")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEstudiante(@PathVariable Long id) {
        if (estudianteService.deleteById(id)) {
            return ResponseEntity.ok(ApiResponse.accepted("Estudiante eliminado exitosamente"));
        }
        return ResponseEntity.status(404).body(ApiResponse.notFound("Estudiante no encontrado"));
    }
}