package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Representa una cita médica para una mascota dentro del sistema veterinario.
 * Contiene información sobre la mascota, el veterinario, fecha, motivo y estado de la cita.
 */
@Entity
@Table(name = "Cita")
public class Cita {

    /**
     * Identificador único de la cita (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cita;

    /**
     * Mascota relacionada con la cita. Relación muchos-a-uno.
     */
    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    /**
     * Veterinario asignado a la cita. Puede ser null si aún no está definido.
     */
    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    /**
     * Fecha programada de la cita (no confundir con fecha de creación).
     */
    @Temporal(TemporalType.DATE)
    private Date fechaCita;

    /**
     * Fecha y hora en que se creó el registro de la cita.
     * No se debe actualizar una vez creada.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date fechaCreacion = new Date();

    /**
     * Motivo de la cita (vacunación, revisión, etc.).
     */
    private String motivo;

    /**
     * Estado actual de la cita (Pendiente, Confirmada, Cancelada, etc.).
     */
    private String estado = "Pendiente";

    /**
     * Notas adicionales proporcionadas por el usuario o el veterinario.
     */
    private String notas;

    // ====== GETTERS Y SETTERS ======

    public Integer getId_cita() {
        return id_cita;
    }

    public void setId_cita(Integer id_cita) {
        this.id_cita = id_cita;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}