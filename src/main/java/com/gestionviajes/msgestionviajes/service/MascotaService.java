package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.MascotaDto;
import com.gestionviajes.msgestionviajes.dto.MascotaResponseDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.repository.DuenioRepository;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DuenioRepository duenioRepository;

    public List<Mascota> findAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> findMascotaById(Integer id) {
        return mascotaRepository.findById(id);
    }

    public List<MascotaResponseDto> getAllMascotaDtos() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public Mascota createMascota(MascotaDto dto) {
        Optional<Duenio> duenioOptional = duenioRepository.findById(dto.getIdDueno());
        if (duenioOptional.isEmpty()) {
            throw new RuntimeException("Dueño no encontrado con id: " + dto.getIdDueno());
        }

        Mascota mascota = new Mascota();
        mascota.setDueno(duenioOptional.get());
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setFechaNacimiento(dto.getFechaNacimiento());
        mascota.setGenero(dto.getGenero());
        mascota.setNumeroMicrochip(dto.getNumeroMicrochip());

        return mascotaRepository.save(mascota);
    }

    public boolean updateMascota(Integer id, MascotaDto dto) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();
            mascota.setNombre(dto.getNombre());
            mascota.setEspecie(dto.getEspecie());
            mascota.setRaza(dto.getRaza());
            mascota.setFechaNacimiento(dto.getFechaNacimiento());
            mascota.setGenero(dto.getGenero());
            mascota.setNumeroMicrochip(dto.getNumeroMicrochip());
            mascotaRepository.save(mascota);
            return true;
        }
        return false;
    }

    public boolean deleteMascota(Integer id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public MascotaResponseDto convertToDto(Mascota mascota) {
        MascotaResponseDto dto = new MascotaResponseDto();
        dto.setId(mascota.getIdMascota());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setRaza(mascota.getRaza());
        dto.setFechaNacimiento(mascota.getFechaNacimiento());
        dto.setGenero(mascota.getGenero());
        dto.setNumeroMicrochip(mascota.getNumeroMicrochip());
        return dto;
    }
}