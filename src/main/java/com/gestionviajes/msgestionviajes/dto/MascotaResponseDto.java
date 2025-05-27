package com.gestionviajes.msgestionviajes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO de respuesta para retornar la información de una mascota.
 * Se utiliza principalmente al consultar datos desde el backend hacia el cliente.
 */
@Getter
@Setter
public class MascotaResponseDto {

    /**
     * ID único de la mascota.
     */
    private Integer id;

    /**
     * Nombre de la mascota.
     */
    private String nombre;

    /**
     * Especie de la mascota (ej. perro, gato).
     */
    private String especie;

    /**
     * Raza de la mascota.
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
     * Número de microchip de la mascota (si aplica).
     */
    private String numeroMicrochip;
}