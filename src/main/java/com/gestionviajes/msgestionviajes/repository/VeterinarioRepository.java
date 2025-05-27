package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para la entidad {@link Veterinario}.
 * Permite realizar operaciones CRUD y consultas personalizadas
 * sobre los registros de veterinarios en la base de datos.
 */
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

    /**
     * Busca un veterinario por su correo electrónico.
     *
     * @param correo Correo del veterinario.
     * @return Un {@link Optional} con el veterinario si se encuentra, o vacío si no.
     */
    Optional<Veterinario> findByCorreo(String correo);

    /**
     * Busca un veterinario por su identificador único.
     *
     * @param id Identificador del veterinario.
     * @return Un {@link Optional} con el veterinario si se encuentra, o vacío si no.
     */
    Optional<Veterinario> findById(Integer id);
}
