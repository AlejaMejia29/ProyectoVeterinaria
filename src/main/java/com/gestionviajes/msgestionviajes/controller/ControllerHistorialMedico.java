package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.HistorialMedicoDto;
import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import com.gestionviajes.msgestionviajes.service.HistorialMedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de historiales médicos.
 * Proporciona endpoints para operaciones CRUD sobre los historiales médicos de mascotas.
 */
@RestController
@RequestMapping("/api/historiales")
@RequiredArgsConstructor
public class ControllerHistorialMedico {

    // Inyección del servicio de historial médico
    @Autowired
    private HistorialMedicoService historialMedicoService;

    /**
     * Obtiene todos los historiales médicos registrados.
     * @return Lista de objetos HistorialMedico.
     */
    @GetMapping
    public ResponseEntity<List<HistorialMedico>> getAll() {
        return ResponseEntity.ok(historialMedicoService.findAll());
    }

    /**
     * Obtiene un historial médico específico por su ID.
     * @param id ID del historial médico
     * @return HistorialMedico encontrado o 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedico> getById(@PathVariable Integer id) {
        return historialMedicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo historial médico asociado a una mascota.
     * @param dto Objeto HistorialMedicoDto con la información médica.
     * @param idMascota ID de la mascota asociada al historial.
     * @return HistorialMedico creado.
     */
    @PostMapping
    public ResponseEntity<HistorialMedico> create(@Valid @RequestBody HistorialMedicoDto dto, @RequestBody Integer idMascota) {
        return ResponseEntity.ok(historialMedicoService.save(dto, idMascota));
    }

    /**
     * Actualiza un historial médico existente.
     * @param id ID del historial médico a actualizar.
     * @param dto Nuevos datos del historial médico.
     * @return Historial actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody HistorialMedicoDto dto) {
        return ResponseEntity.ok(historialMedicoService.update(id, dto));
    }

    /**
     * Elimina un historial médico por su ID.
     * @param id ID del historial a eliminar.
     * @return 200 OK si se elimina, 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = historialMedicoService.deleteById(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
