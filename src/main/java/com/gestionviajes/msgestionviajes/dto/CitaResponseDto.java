package com.gestionviajes.msgestionviajes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO de respuesta para retornar información de una cita al cliente.
 * Se utiliza para exponer los datos relevantes de una cita sin mostrar toda la entidad.
 */
@Getter
@Setter
public class CitaResponseDto {

    /**
     * Identificador único de la cita.
     */
    private Integer idCita;

    /**
     * Fecha y hora de la cita.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date fechaCita;

    /**
     * Motivo de la cita (ej. revisión, vacunación).
     */
    private String motivo;

    /**
     * Estado actual de la cita (ej. Pendiente, Completada, Cancelada).
     */
    private String estado;

    /**
     * Notas adicionales sobre la cita.
     */
    private String notas;

    /**
     * ID de la mascota asociada a la cita.
     */
    private Integer idMascota;

    /**
     * ID del veterinario asignado a la cita.
     */
    private Integer idVeterinario;
}