package com.gestionviajes.msgestionviajes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO (Data Transfer Object) para representar una cita médica veterinaria.
 * Este objeto se usa para recibir datos del cliente al crear o actualizar una cita.
 */
@Getter
@Setter
public class CitaDto {

    /**
     * Fecha y hora programada para la cita.
     * Se debe usar el mismo tipo que en la entidad (java.util.Date).
     * El formato JSON asegura compatibilidad al recibir la fecha desde el frontend.
     */
    @NotNull(message = "La fecha de la cita no puede ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date fechaCita;

    /**
     * Identificador de la cita (puede ser nulo al crear una nueva).
     */
    private Integer idCita;

    /**
     * Motivo de la cita (consulta, chequeo, urgencia, etc.).
     */
    private String motivo;

    /**
     * Estado actual de la cita. Por defecto es "Pendiente".
     */
    private String estado = "Pendiente";

    /**
     * Notas adicionales del veterinario o del sistema.
     */
    private String notas;

    /**
     * ID del veterinario que atenderá la cita.
     */
    private Integer idVeterinario;

    /**
     * ID de la mascota asociada a la cita.
     */
    private Integer idMascota;
}