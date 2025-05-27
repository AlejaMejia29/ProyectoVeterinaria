package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad {@link Mascota}.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * sobre los registros de mascotas en la base de datos.
 */
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    /**
     * Busca una lista de mascotas por especie.
     *
     * @param especie Especie de la mascota (por ejemplo: "Perro", "Gato").
     * @return Lista de mascotas que coinciden con la especie proporcionada.
     */
    List<Mascota> findByEspecie(String especie);
}
