package com.example.backend.mapper;

import com.example.backend.dto.EstudianteDTO;
import com.example.backend.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);
    
    EstudianteDTO toDTO(Estudiante estudiante);
    
    Estudiante toEntity(EstudianteDTO estudianteDTO);
    
    List<EstudianteDTO> toDTOList(List<Estudiante> estudiantes);
    
    List<Estudiante> toEntityList(List<EstudianteDTO> estudianteDTOs);
}