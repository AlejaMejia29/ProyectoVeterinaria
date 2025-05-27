package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.CitaDto;
import com.gestionviajes.msgestionviajes.dto.CitaResponseDto;
import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.service.CitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de citas.
 * Proporciona endpoints para operaciones CRUD sobre citas.
 */
@RestController
@RequestMapping("api/citas")
@RequiredArgsConstructor
public class ControllerCita {

    // Inyección del servicio que maneja la lógica de negocio de las citas
    @Autowired
    private CitaService citaService;

    /**
     * Obtiene todas las citas registradas en el sistema.
     * @return Lista de CitaResponseDto
     */
    @GetMapping
    public ResponseEntity<List<CitaResponseDto>> getAllCitas() {
        return ResponseEntity.ok(citaService.getAllCitaDtos());
    }

    /**
     * Obtiene una cita específica por su ID.
     * @param id Identificador de la cita
     * @return CitaResponseDto si se encuentra, 404 si no
     */
    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDto> getCitaById(@PathVariable Integer id) {
        return citaService.findCitaById(id)
                .map(citaService::mapToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea una nueva cita asociada a una mascota.
     * @param idMascota ID de la mascota
     * @param citaDto Datos de la cita a crear
     * @return CitaResponseDto creada o error si falla
     */
    @PostMapping("/mascota/{idMascota}")
    public ResponseEntity<?> createCita(@PathVariable Integer idMascota, @Valid @RequestBody CitaDto citaDto) {
        try {
            Cita cita = citaService.saveCita(citaDto, idMascota);
            CitaResponseDto response = citaService.mapToDto(cita);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Actualiza los datos de una cita existente.
     * @param id ID de la cita a actualizar
     * @param citaDto Nuevos datos de la cita
     * @return 200 OK si se actualizó, 404 si no se encuentra, 400 si hay error
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCita(@PathVariable Integer id, @Valid @RequestBody CitaDto citaDto) {
        try {
            boolean updated = citaService.updateCita(id, citaDto);
            return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Elimina una cita por su ID.
     * @param id ID de la cita a eliminar
     * @return 200 OK si se elimina, 404 si no se encuentra
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        boolean deleted = citaService.deleteCita(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
