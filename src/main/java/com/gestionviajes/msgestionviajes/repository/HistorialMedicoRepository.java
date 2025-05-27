package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad {@link HistorialMedico}.
 * Permite realizar operaciones CRUD y consultas personalizadas
 * sobre los historiales médicos almacenados en la base de datos.
 */
@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer> {

    /**
     * Busca historiales médicos cuyo diagnóstico contenga una palabra clave,
     * sin importar mayúsculas o minúsculas.
     *
     * @param keyword Palabra clave a buscar dentro del diagnóstico.
     * @return Lista de historiales médicos que contienen la palabra clave.
     */
    List<HistorialMedico> findByDiagnósticoContainingIgnoreCase(String keyword);

    /**
     * Retorna todos los historiales médicos registrados en la base de datos.
     *
     * @return Lista completa de historiales médicos.
     */
    List<HistorialMedico> findAll();
}
