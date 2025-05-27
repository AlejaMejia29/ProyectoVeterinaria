package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio para manejar las operaciones CRUD relacionadas con las entidades {@link Cita}.
 */
@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    /**
     * Obtiene una lista de citas filtradas por su estado (por ejemplo: "Pendiente", "Confirmada", "Cancelada").
     *
     * @param estado Estado de la cita.
     * @return Lista de citas que coincidan con el estado proporcionado.
     */
    List<Cita> findByEstado(String estado);

    /**
     * Busca una cita específica por su fecha y la mascota a la que está asignada.
     * Se puede usar para evitar duplicación de citas para una misma mascota en la misma fecha.
     *
     * @param fechaCita Fecha programada de la cita.
     * @param mascota   Mascota asociada a la cita.
     * @return Un {@link Optional} que contiene la cita si existe.
     */
    Optional<Cita> findByFechaCitaAndMascota(Date fechaCita, Mascota mascota);
}
