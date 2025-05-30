package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;

    @ManyToOne
    @JoinColumn(name = "id_dueno", nullable = false)
    private Duenio duenio;

    private String nombre;
    private String especie;
    private String raza;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String genero;
    private String numeroMicrochip;

    @Temporal(TemporalType.DATE)
    private Date fechaCreacion = new Date();

    // Getters y setters

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDueno(Duenio dueno) {
        this.duenio = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumeroMicrochip() {
        return numeroMicrochip;
    }

    public void setNumeroMicrochip(String numeroMicrochip) {
        this.numeroMicrochip = numeroMicrochip;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}