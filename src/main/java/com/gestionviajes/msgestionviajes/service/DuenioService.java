package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.DuenioDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los dueños de mascotas.
 * Permite operaciones CRUD sobre la entidad {@link Duenio}.
 */
@Service
public class DuenioService {

    @Autowired
    private DuenioRepository duenioRepository;

    /**
     * Obtiene la lista de todos los dueños registrados.
     *
     * @return Lista de objetos {@link Duenio}.
     */
    public List<Duenio> findAll() {
        return duenioRepository.findAll();
    }

    /**
     * Busca un dueño por su identificador.
     *
     * @param id Identificador del dueño.
     * @return Un {@link Optional} que contiene el dueño si se encuentra.
     */
    public Optional<Duenio> findById(Integer id) {
        return duenioRepository.findById(id);
    }

    /**
     * Busca un dueño por su correo electrónico.
     *
     * @param correo Correo del dueño.
     * @return Un {@link Optional} que contiene el dueño si se encuentra.
     */
    public Optional<Duenio> findByCorreo(String correo) {
        return duenioRepository.findByCorreo(correo);
    }

    /**
     * Registra un nuevo dueño en el sistema.
     *
     * @param dto Objeto {@link DuenioDto} con los datos del dueño.
     * @return El objeto {@link Duenio} guardado.
     * @throws RuntimeException si ya existe un dueño con el mismo correo.
     */
    public Duenio save(DuenioDto dto) {
        if (duenioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new RuntimeException("Ya existe un dueño con ese correo.");
        }

        Duenio duenio = new Duenio();
        duenio.setNombre(dto.getNombre());
        duenio.setApellidos(dto.getApellidos());
        duenio.setCorreo(dto.getCorreo());
        duenio.setTeléfono(dto.getTeléfono());
        duenio.setDirección(dto.getDirección());
        return duenioRepository.save(duenio);
    }

    /**
     * Actualiza los datos de un dueño existente.
     *
     * @param id  Identificador del dueño a actualizar.
     * @param dto Datos nuevos del dueño.
     * @return true si el dueño fue actualizado correctamente, false si no existe.
     */
    public boolean update(Integer id, DuenioDto dto) {
        Optional<Duenio> optional = duenioRepository.findById(id);
        if (optional.isPresent()) {
            Duenio duenio = optional.get();
            duenio.setNombre(dto.getNombre());
            duenio.setApellidos(dto.getApellidos());
            duenio.setCorreo(dto.getCorreo());
            duenio.setTeléfono(dto.getTeléfono());
            duenio.setDirección(dto.getDirección());
            duenioRepository.save(duenio);
            return true;
        }
        return false;
    }

    /**
     * Elimina un dueño del sistema por su identificador.
     *
     * @param id Identificador del dueño.
     * @return true si fue eliminado correctamente, false si no existe.
     */
    public boolean delete(Integer id) {
        if (duenioRepository.existsById(id)) {
            duenioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
