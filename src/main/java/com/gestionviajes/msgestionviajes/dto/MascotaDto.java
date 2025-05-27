package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO utilizado para crear o actualizar los datos de una mascota.
 * Permite validar los datos básicos requeridos para su registro.
 */
@Getter
@Setter
public class MascotaDto {

    /**
     * ID del dueño al que pertenece la mascota.
     */
    private Integer idDueno;

    /**
     * Nombre de la mascota. Campo obligatorio.
     */
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    /**
     * Especie de la mascota (ej. perro, gato). Campo obligatorio.
     */
    @NotBlank(message = "Especie es obligatoria")
    private String especie;

    /**
     * Raza de la mascota (opcional).
     */
    private String raza;

    /**
     * Fecha de nacimiento de la mascota.
     */
    private Date fechaNacimiento;

    /**
     * Genero de la mascota (ej. macho, hembra).
     */
    private String genero;

    /**
     * Número de microchip si tiene (opcional).
     */
    private String numeroMicrochip;
}