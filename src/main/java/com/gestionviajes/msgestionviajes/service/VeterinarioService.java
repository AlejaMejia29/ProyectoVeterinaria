package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.VeterinarioDto;
import com.gestionviajes.msgestionviajes.model.Veterinario;
import com.gestionviajes.msgestionviajes.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> findAll() {
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> findById(Integer id) {
        return veterinarioRepository.findById(id);
    }

    public Optional<Veterinario> findByCorreo(String correo) {
        return veterinarioRepository.findByCorreo(correo);
    }

    public Veterinario saveVeterinario(VeterinarioDto veterinarioDto) {
        if (veterinarioRepository.findByCorreo(veterinarioDto.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un veterinario con ese correo.");
        }

        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(veterinarioDto.getNombre());
        veterinario.setApellidos(veterinarioDto.getApellidos());
        veterinario.setEspecialización(veterinarioDto.getEspecialización());
        veterinario.setCorreo(veterinarioDto.getCorreo());
        veterinario.setTelefono(veterinarioDto.getTelefono()); // <- debe ser Long en el modelo

        return veterinarioRepository.save(veterinario);
    }

    public boolean updateVeterinario(Integer id, VeterinarioDto dto) {
        Optional<Veterinario> optionalVeterinario = veterinarioRepository.findById(id);
        if (optionalVeterinario.isPresent()) {
            Veterinario vetToUpdate = optionalVeterinario.get();

            Optional<Veterinario> existingByCorreo = veterinarioRepository.findByCorreo(dto.getCorreo());
            if (existingByCorreo.isPresent() && !existingByCorreo.get().getId_veterinario().equals(id)) {
                throw new IllegalArgumentException("Ya existe otro veterinario con ese correo.");
            }

            vetToUpdate.setNombre(dto.getNombre());
            vetToUpdate.setApellidos(dto.getApellidos());
            vetToUpdate.setCorreo(dto.getCorreo());
            vetToUpdate.setTelefono(dto.getTelefono()); // <- debe ser Long en el modelo

            veterinarioRepository.save(vetToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteVeterinario(Integer id) {
        if (veterinarioRepository.existsById(id)) {
            veterinarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Veterinario updateVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }
}