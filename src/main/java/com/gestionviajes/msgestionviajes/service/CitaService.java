package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.CitaDto;
import com.gestionviajes.msgestionviajes.dto.CitaResponseDto;
import com.gestionviajes.msgestionviajes.exception.SaveCitaNotFoundException;
import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.model.Veterinario;
import com.gestionviajes.msgestionviajes.repository.CitaRepository;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import com.gestionviajes.msgestionviajes.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona la lógica de negocio relacionada con las citas médicas veterinarias.
 */
@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Cita saveCita(CitaDto citaDto, Integer idMascota) {
        Mascota mascota = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new SaveCitaNotFoundException("Mascota no encontrada con id: " + idMascota));

        Veterinario veterinario = veterinarioRepository.findById(citaDto.getIdVeterinario())
                .orElseThrow(() -> new SaveCitaNotFoundException("Veterinario no encontrado con id: " + citaDto.getIdVeterinario()));

        Optional<Cita> citaExistente = citaRepository.findByFechaCitaAndMascota(citaDto.getFechaCita(), mascota);
        if (citaExistente.isPresent()) {
            throw new SaveCitaNotFoundException("Ya existe una cita para esta fecha y mascota");
        }

        Cita cita = new Cita();
        cita.setFechaCita(citaDto.getFechaCita());
        cita.setMotivo(citaDto.getMotivo());
        cita.setEstado(citaDto.getEstado());
        cita.setNotas(citaDto.getNotas());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);

        return citaRepository.save(cita);
    }

    public boolean updateCita(Integer id, CitaDto citaDto) {
        Optional<Cita> optionalCita = citaRepository.findById(id);
        if (optionalCita.isPresent()) {
            Cita citaToUpdate = optionalCita.get();
            citaToUpdate.setFechaCita(citaDto.getFechaCita());
            citaToUpdate.setMotivo(citaDto.getMotivo());
            citaToUpdate.setEstado(citaDto.getEstado());
            citaToUpdate.setNotas(citaDto.getNotas());
            citaRepository.save(citaToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCita(Integer id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Cita> findAllCitas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> findCitaById(Integer id) {
        return citaRepository.findById(id);
    }

    public CitaResponseDto mapToDto(Cita cita) {
        CitaResponseDto dto = new CitaResponseDto();
        dto.setIdCita(cita.getId_cita());
        dto.setFechaCita(cita.getFechaCita());
        dto.setMotivo(cita.getMotivo());
        dto.setEstado(cita.getEstado());
        dto.setNotas(cita.getNotas());
        dto.setIdMascota(cita.getMascota().getIdMascota());
        dto.setIdVeterinario(cita.getVeterinario().getId_veterinario());
        return dto;
    }

    public List<CitaResponseDto> getAllCitaDtos() {
        return findAllCitas().stream()
                .map(this::mapToDto)
                .toList();
    }
}