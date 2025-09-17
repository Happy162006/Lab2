package sv.edu.udb.spring_api_rest.controller;

import sv.edu.udb.spring_api_rest.dto.Perfildto;
import sv.edu.udb.spring_api_rest.dto.Presponse;
import sv.edu.udb.spring_api_rest.model.Perfil;
import sv.edu.udb.spring_api_rest.service.PerfilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    // POST /api/perfiles
    @PostMapping
    public ResponseEntity crearPerfil(@Valid @RequestBody Perfildto dto) {
        Presponse creado = perfilService.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

// GET /api/perfiles
    @GetMapping
    public ResponseEntity listarPerfiles() {
        return ResponseEntity.ok(perfilService.listar());
    }

    // GET /api/perfiles/{id}
    @GetMapping("/{id}")
    public ResponseEntity obtenerPerfil(@PathVariable Long id) {
        return ResponseEntity.ok(perfilService.buscarPorId(id));
    }

    // PUT /api/perfiles/{id}
    @PutMapping("/{id}")
    public ResponseEntity actualizarPerfil(@PathVariable Long id, @Valid @RequestBody Perfildto dto) {
        return ResponseEntity.ok(perfilService.actualizar(id, dto));
    }

    // DELETE /api/perfiles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPerfil(@PathVariable Long id) {
        perfilService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // GET /saludo/{apellido}
    @GetMapping("/saludo/{apellido}")
    public ResponseEntity saludo(@PathVariable String apellido) {
        return ResponseEntity.ok("¡Hola, " + apellido + "!");
    }
}