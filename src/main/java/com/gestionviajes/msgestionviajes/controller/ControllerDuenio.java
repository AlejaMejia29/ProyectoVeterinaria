package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.DuenioDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.service.DuenioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de dueños (Duenio).
 * Permite realizar operaciones CRUD sobre los dueños registrados.
 */
@RestController
@RequestMapping("/api/duenios")
public class ControllerDuenio {

    // Inyección del servicio de dueños
    @Autowired
    private DuenioService duenioService;

    /**
     * Obtiene todos los dueños registrados.
     * @return Lista de objetos Duenio.
     */
    @GetMapping
    public ResponseEntity<List<Duenio>> getAll() {
        return ResponseEntity.ok(duenioService.findAll());
    }

    /**
     * Obtiene un dueño por su ID.
     * @param id ID del dueño
     * @return Objeto Duenio si se encuentra, o 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Duenio> getById(@PathVariable Integer id) {
        return duenioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo dueño.
     * @param dto Objeto DuenioDto con los datos del nuevo dueño.
     * @return Dueño creado o mensaje de error.
     */
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DuenioDto dto) {
        try {
            Duenio nuevo = duenioService.save(dto);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Actualiza un dueño existente.
     * @param id ID del dueño a actualizar.
     * @param dto Objeto DuenioDto con la nueva información.
     * @return 200 OK si se actualiza, 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody DuenioDto dto) {
        Optional<Duenio> updated = (duenioService.update(id, dto));
        return updated
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un dueño por su ID.
     * @param id ID del dueño a eliminar.
     * @return 200 OK si se elimina, 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = duenioService.delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
