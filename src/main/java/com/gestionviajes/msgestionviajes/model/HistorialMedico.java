package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Entidad que representa el historial médico de una mascota.
 * Contiene información relacionada a una cita específica, el diagnóstico, tratamiento,
 * medicación, notas adicionales y la fecha en que se registró.
 *
 * Esta clase está mapeada a la tabla "Historiales_Medicos" en la base de datos.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Historiales_Medicos")
@Builder
public class HistorialMedico {

    /**
     * Identificador único del historial médico.
     * Se genera automáticamente con estrategia de incremento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_historial;

    /**
     * Cita médica asociada al historial.
     * Relación uno a uno con la entidad Cita.
     */
    @OneToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    /**
     * Mascota a la que pertenece el historial médico.
     * Relación muchos a uno con la entidad Mascota.
     */
    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    /**
     * Diagnóstico realizado durante la cita.
     */
    private String diagnóstico;

    /**
     * Tratamiento indicado para la mascota.
     */
    private String tratamiento;

    /**
     * Medicación recetada en el historial médico.
     */
    private String medicación;

    /**
     * Notas adicionales agregadas por el veterinario.
     */
    private String notas;

    /**
     * Fecha en que fue creado el historial médico.
     */
    private Date fecha_creación;
}
