package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO para la creación o actualización de datos de un dueño de mascota.
 * Se utiliza para validar y transportar la información desde el cliente hacia el backend.
 */
@Getter
@Setter
public class DuenioDto {

    /**
     * Nombre del dueño. No puede estar en blanco.
     */
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    /**
     * Apellidos del dueño. No pueden estar en blanco.
     */
    @NotBlank(message = "Apellidos son obligatorios")
    private String apellidos;

    /**
     * Correo electrónico del dueño. Debe ser válido y no puede estar vacío.
     */
    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    /**
     * Número de teléfono del dueño. Debe contener solo dígitos (7 a 15).
     */
    @NotBlank(message = "Teléfono es obligatorio")
    @Pattern(regexp = "\\d{7,15}", message = "El teléfono debe contener solo números y tener entre 7 y 15 dígitos")
    private String telefono;

    /**
     * Dirección de residencia del dueño (opcional).
     */
    private String direccion;
}
