package com.example.backend.mapper;

import com.example.backend.dto.EstudianteDTO;
import com.example.backend.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper manual para convertir entre Estudiante y EstudianteDTO
 * Esta es una alternativa al mapper automático de MapStruct
 */
@Component
public class EstudianteMapperManual {
    
    /**
     * Convierte una entidad Estudiante a EstudianteDTO
     */
    public EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }
        
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setEmail(estudiante.getEmail());
        dto.setEdad(estudiante.getEdad());
        dto.setCarrera(estudiante.getCarrera());
        
        return dto;
    }
    
    /**
     * Convierte un EstudianteDTO a entidad Estudiante
     */
    public Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Estudiante estudiante = new Estudiante();
        estudiante.setId(dto.getId());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setEmail(dto.getEmail());
        estudiante.setEdad(dto.getEdad());
        estudiante.setCarrera(dto.getCarrera());
        
        return estudiante;
    }
    
    /**
     * Convierte una lista de entidades Estudiante a lista de EstudianteDTO
     */
    public List<EstudianteDTO> toDTOList(List<Estudiante> estudiantes) {
        if (estudiantes == null) {
            return null;
        }
        
        return estudiantes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Convierte una lista de EstudianteDTO a lista de entidades Estudiante
     */
    public List<Estudiante> toEntityList(List<EstudianteDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
    
    /**
     * Actualiza una entidad existente con los datos del DTO
     * Útil para operaciones de actualización donde queremos mantener el ID
     */
    public void updateEntityFromDTO(EstudianteDTO dto, Estudiante estudiante) {
        if (dto == null || estudiante == null) {
            return;
        }
        
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setEmail(dto.getEmail());
        estudiante.setEdad(dto.getEdad());
        estudiante.setCarrera(dto.getCarrera());
    }
}