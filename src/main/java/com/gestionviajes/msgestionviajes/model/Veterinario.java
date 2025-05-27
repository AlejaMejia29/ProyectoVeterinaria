package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Representa un veterinario registrado en el sistema de la veterinaria.
 * Contiene información personal y profesional como nombre, especialización,
 * correo electrónico, teléfono y fecha de creación del registro.
 */
@Entity
@Table(name = "Veterinario")
public class Veterinario {

    /**
     * Identificador único del veterinario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veterinario;

    /**
     * Nombre del veterinario.
     */
    private String nombre;

    /**
     * Apellidos del veterinario.
     */
    private String apellidos;

    /**
     * Área de especialización médica del veterinario.
     */
    private String especialización;

    /**
     * Correo electrónico del veterinario.
     */
    private String correo;

    /**
     * Número de teléfono de contacto.
     */
    private Long telefono;

    /**
     * Fecha en que se registró al veterinario en el sistema.
     */
    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();

    // Getters y setters

    public Integer getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Integer id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialización() {
        return especialización;
    }

    public void setEspecialización(String especialización) {
        this.especialización = especialización;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_creación() {
        return fecha_creación;
    }

    public void setFecha_creación(Date fecha_creación) {
        this.fecha_creación = fecha_creación;
    }
}