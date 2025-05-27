package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entidad que representa al dueño de una o más mascotas.
 * Contiene información personal básica y la relación con sus mascotas.
 */
@Entity
@Table(name = "Duenio")
@Getter
@Setter
public class Duenio {

    /**
     * Identificador único del dueño. Generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dueño;

    /**
     * Nombre del dueño.
     */
    private String nombre;

    /**
     * Apellidos del dueño.
     */
    private String apellidos;

    /**
     * Correo electrónico del dueño.
     */
    private String correo;

    /**
     * Número telefónico del dueño.
     */
    private String telefono;

    /**
     * Dirección de residencia del dueño.
     */
    private String direccion;

    /**
     * Lista de mascotas asociadas a este dueño.
     * Relación uno a muchos.
     */
    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

    /**
     * Fecha de creación del registro del dueño.
     * Se inicializa automáticamente con la fecha actual.
     */
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion = new Date();
}
