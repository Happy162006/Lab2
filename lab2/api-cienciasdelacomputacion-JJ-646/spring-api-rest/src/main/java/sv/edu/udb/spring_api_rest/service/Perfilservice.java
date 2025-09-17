package sv.edu.udb.spring_api_rest.service;

import sv.edu.udb.spring_api_rest.dto.Perfildto;
import sv.edu.udb.spring_api_rest.dto.Presponse;
import sv.edu.udb.spring_api_rest.model.Perfil;
import sv.edu.udb.spring_api_rest.repository.PerfilRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository perfilRepository;

    // Crear un perfil
    public Presponse crear(Perfildto dto) {
        Perfil perfil = Perfil.builder()
                .nombreCompleto(dto.getNombreCompleto())
                .apellido(dto.getApellido())
                .carnet(dto.getCarnet())
                .carrera(dto.getCarrera())
                .cohorte(dto.getCohorte())
                .build();

        Perfil guardado = perfilRepository.saveAndFlush(perfil);

        return convertirADTO(guardado);
    }

    // Buscar por ID
    public Presponse buscarPorId(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil con id " + id + " no encontrado"));
        return convertirADTO(perfil);
    }

    // Listar todos
    public List listar() {
        return PerfilRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Actualizar
    public Presponse actualizar(Long id, Perfildto dto) {
        Perfil perfil = PerfilRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil con id " + id + " no encontrado"));

        perfil.setNombreCompleto(dto.getNombreCompleto());
        perfil.setApellido(dto.getApellido());
        perfil.setCarnet(dto.getCarnet());
        perfil.setCarrera(dto.getCarrera());
        perfil.setCohorte(dto.getCohorte());

        Perfil actualizado = PerfilRepository.save(perfil);
        return convertirADTO(actualizado);
    }

    // Eliminar
    public void eliminar(Long id) {
        if (!PerfilRepository.existsById(id)) {
            throw new EntityNotFoundException("Perfil con id " + id + " no encontrado");
        }
        PerfilRepository.deleteById(id);
    }

    // Conversión de Entidad a PResponse
    private Presponse convertirADTO(Perfil perfil) {
        return Presponse.builder()
                .id(perfil.getId())
                .nombreCompleto(perfil.getNombreCompleto())
                .apellido(perfil.getApellido())
                .carnet(perfil.getCarnet())
                .carrera(perfil.getCarrera())
                .cohorte(perfil.getCohorte())
                .build();
    }
}