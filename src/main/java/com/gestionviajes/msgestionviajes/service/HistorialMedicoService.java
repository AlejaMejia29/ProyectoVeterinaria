package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.HistorialMedicoDto;
import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.repository.HistorialMedicoRepository;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que maneja la lógica de negocio relacionada con el historial médico de las mascotas.
 * Permite crear, actualizar, eliminar y consultar historiales médicos.
 */
@Service
@RequiredArgsConstructor
public class HistorialMedicoService {

    private final HistorialMedicoRepository historialMedicoRepository;
    private final MascotaRepository mascotaRepository;

    /**
     * Guarda un nuevo historial médico asociado a una mascota.
     *
     * @param dto       Datos del historial médico.
     * @param idMascota Identificador de la mascota.
     * @return El historial médico guardado.
     * @throws RuntimeException Si no se encuentra la mascota con el ID proporcionado.
     */
    @Transactional
    public HistorialMedico save(HistorialMedicoDto dto, Integer idMascota) {
        Optional<Mascota> mascotaOpt = mascotaRepository.findById(idMascota);
        if (mascotaOpt.isEmpty()) {
            throw new RuntimeException("No se encontró una mascota con el ID proporcionado: " + idMascota);
        }

        Mascota mascota = mascotaOpt.get();

        HistorialMedico historial = new HistorialMedico();
        historial.setDiagnóstico(dto.getDiagnóstico());
        historial.setTratamiento(dto.getTratamiento());
        historial.setMedicación(dto.getMedicación());
        historial.setNotas(dto.getNotas());
        historial.setMascota(mascota);

        return historialMedicoRepository.save(historial);
    }

    /**
     * Busca un historial médico por su ID.
     *
     * @param id Identificador del historial médico.
     * @return Un {@link Optional} que contiene el historial si se encuentra.
     */
    public Optional<HistorialMedico> findById(Integer id) {
        return historialMedicoRepository.findById(id);
    }

    /**
     * Elimina un historial médico por su ID.
     *
     * @param id Identificador del historial médico.
     * @return true si se eliminó correctamente, false si no existía.
     * @throws RuntimeException Si no se encuentra el historial con el ID proporcionado.
     */
    public boolean deleteById(Integer id) {
        if (historialMedicoRepository.existsById(id)) {
            historialMedicoRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("No se encontró un historial médico con el ID proporcionado: " + id);
        }
    }

    /**
     * Obtiene todos los historiales médicos registrados.
     *
     * @return Lista de historiales médicos.
     */
    public List<HistorialMedico> findAll() {
        return historialMedicoRepository.findAll();
    }

    /**
     * Actualiza un historial médico existente.
     *
     * @param id  Identificador del historial a actualizar.
     * @param dto Datos nuevos del historial.
     * @return El historial médico actualizado.
     * @throws RuntimeException Si no se encuentra el historial con el ID proporcionado.
     */
    public HistorialMedico update(Integer id, HistorialMedicoDto dto) {
        Optional<HistorialMedico> optional = historialMedicoRepository.findById(id);
        if (optional.isPresent()) {
            HistorialMedico historial = optional.get();
            historial.setDiagnóstico(dto.getDiagnóstico());
            historial.setTratamiento(dto.getTratamiento());
            historial.setMedicación(dto.getMedicación());
            historial.setNotas(dto.getNotas());
            return historialMedicoRepository.save(historial);
        }
        throw new RuntimeException("No se encontró un historial médico con el ID proporcionado: " + id);
    }
}
