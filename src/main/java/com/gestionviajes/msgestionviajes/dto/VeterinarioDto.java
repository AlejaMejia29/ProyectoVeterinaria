package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO utilizado para crear o actualizar los datos de un veterinario.
 * Incluye validaciones básicas para garantizar la integridad de los datos.
 */
@Getter
@Setter
public class VeterinarioDto {

    /**
     * Nombre del veterinario. Campo obligatorio.
     */
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    /**
     * Apellidos del veterinario. Campo obligatorio.
     */
    @NotBlank(message = "Apellidos son obligatorios")
    private String apellidos;

    /**
     * Especialización del veterinario (opcional).
     */
    private String especialización;

    /**
     * Correo electrónico del veterinario. Debe ser válido. Campo obligatorio.
     */
    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    /**
     * Número telefónico del veterinario.
     */
    private Long telefono;
}