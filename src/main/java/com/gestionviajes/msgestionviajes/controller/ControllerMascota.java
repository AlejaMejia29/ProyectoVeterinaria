package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.MascotaDto;
import com.gestionviajes.msgestionviajes.dto.MascotaResponseDto;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.service.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de mascotas.
 * Permite realizar operaciones CRUD sobre las mascotas registradas.
 */
@RestController
@RequestMapping("api/mascotas")
@RequiredArgsConstructor
public class ControllerMascota {

    // Inyección del servicio de mascotas
    @Autowired
    private MascotaService mascotaService;

    /**
     * Obtiene una mascota por su ID.
     * @param id ID de la mascota
     * @return MascotaResponseDto si se encuentra, 404 si no.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> getMascotaById(@PathVariable Integer id) {
        return mascotaService.findMascotaById(id)
                .map(mascotaService::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Obtiene todas las mascotas registradas.
     * @return Lista de MascotaResponseDto.
     */
    @GetMapping
    public ResponseEntity<List<MascotaResponseDto>> getAllMascotas() {
        return ResponseEntity.ok(mascotaService.getAllMascotaDtos());
    }

    /**
     * Crea una nueva mascota.
     * @param dto Objeto MascotaDto con la información de la nueva mascota.
     * @return Objeto Mascota creado.
     */
    @PostMapping
    public ResponseEntity<Mascota> createMascota(@Valid @RequestBody MascotaDto dto) {
        return ResponseEntity.ok(mascotaService.createMascota(dto));
    }

    /**
     * Actualiza los datos de una mascota existente.
     * @param id ID de la mascota a actualizar.
     * @param dto Datos nuevos para la mascota.
     * @return 200 OK si se actualiza, 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMascota(@PathVariable Integer id, @Valid @RequestBody MascotaDto dto) {
        boolean updated = mascotaService.updateMascota(id, dto);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /**
     * Elimina una mascota por su ID.
     * @param id ID de la mascota a eliminar.
     * @return 200 OK si se elimina, 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Integer id) {
        boolean deleted = mascotaService.deleteMascota(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
