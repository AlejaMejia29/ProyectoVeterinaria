package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para la entidad {@link Duenio}.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * sobre los datos de los dueños en la base de datos.
 */
public interface DuenioRepository extends JpaRepository<Duenio, Integer> {

    /**
     * Busca un dueño por su correo o número de teléfono.
     *
     * @param correo   Correo electrónico del dueño.
     * @param teléfono Número de teléfono del dueño.
     * @return Un {@link Optional} que contiene el dueño si se encuentra, o vacío si no.
     */
    Optional<Duenio> findByCorreoOrTelefono(String correo, String teléfono);

    /**
     * Busca un dueño únicamente por su correo electrónico.
     *
     * @param correo Correo electrónico del dueño.
     * @return Un {@link Optional} que contiene el dueño si se encuentra, o vacío si no.
     */
    Optional<Duenio> findByCorreo(String correo);
}
