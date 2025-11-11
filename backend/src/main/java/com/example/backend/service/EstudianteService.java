package com.example.backend.service;

import com.example.backend.dto.EstudianteDTO;
import com.example.backend.model.Estudiante;
import com.example.backend.mapper.EstudianteMapper;
import com.example.backend.mapper.EstudianteMapperManual;
import com.example.backend.projection.EstudianteProjection;
import com.example.backend.projection.EstudianteResumenProjection;
import com.example.backend.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteService {
    
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper; // MapStruct mapper
    private final EstudianteMapperManual estudianteMapperManual; // Manual mapper
    
    // Métodos usando MapStruct
    public List<EstudianteDTO> getAllEstudiantesDTO() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudianteMapper.toDTOList(estudiantes);
    }
    
    public Optional<EstudianteDTO> getEstudianteDTOById(Long id) {
        return estudianteRepository.findById(id)
                .map(estudianteMapper::toDTO);
    }
    
    public EstudianteDTO createEstudianteFromDTO(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = estudianteMapper.toEntity(estudianteDTO);
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return estudianteMapper.toDTO(savedEstudiante);
    }
    
    // Métodos usando mapper manual (alternativa)
    public List<EstudianteDTO> getAllEstudiantesDTOManual() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudianteMapperManual.toDTOList(estudiantes);
    }
    
    public EstudianteDTO createEstudianteFromDTOManual(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = estudianteMapperManual.toEntity(estudianteDTO);
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return estudianteMapperManual.toDTO(savedEstudiante);
    }
    
    // Métodos con proyecciones para optimizar consultas
    public List<EstudianteProjection> getAllEstudiantesProjected() {
        return estudianteRepository.findAllProjected();
    }
    
    public List<EstudianteResumenProjection> getAllEstudiantesResumen() {
        return estudianteRepository.findAllResumen();
    }
    
    public List<EstudianteProjection> getEstudiantesByCarreraProjected(String carrera) {
        return estudianteRepository.findByCarreraProjected(carrera);
    }
    
    // Métodos tradicionales con entidades
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }
    
    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }
    
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
    
    public Optional<EstudianteDTO> updateEstudiante(Long id, EstudianteDTO estudianteDTO) {
        return estudianteRepository.findById(id)
                .map(existingEstudiante -> {
                    // Usando mapper manual para actualización
                    estudianteMapperManual.updateEntityFromDTO(estudianteDTO, existingEstudiante);
                    Estudiante updatedEstudiante = estudianteRepository.save(existingEstudiante);
                    return estudianteMapper.toDTO(updatedEstudiante);
                });
    }
    
    public boolean deleteById(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Métodos de validación y búsqueda
    public boolean existsByEmail(String email) {
        return estudianteRepository.findByEmail(email).isPresent();
    }
    
    public List<Estudiante> findByCarrera(String carrera) {
        return estudianteRepository.findByCarrera(carrera);
    }
    
    public List<Estudiante> findByEdadBetween(Integer edadMin, Integer edadMax) {
        return estudianteRepository.findByEdadBetween(edadMin, edadMax);
    }
    
    public Long countByCarrera(String carrera) {
        return estudianteRepository.countByCarrera(carrera);
    }
}