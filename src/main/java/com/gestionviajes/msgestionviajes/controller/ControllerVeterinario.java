//package com.gestionviajes.msgestionviajes.controller;
//
//import com.gestionviajes.msgestionviajes.dto.VeterinarioDto;
//import com.gestionviajes.msgestionviajes.model.Veterinario;
//import com.gestionviajes.msgestionviajes.service.VeterinarioService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/veterinarios")
//@RequiredArgsConstructor
//public class ControllerVeterinario {
//
//    private final VeterinarioService veterinarioService;
//
//    @GetMapping("/form")
//    public String mostrarFormulario(Model model) {
//        model.addAttribute("veterinarioDto", new VeterinarioDto());
//        return "veterinario-form"; // apunta a src/main/resources/templates/veterinario-form.html
//    }
//
//    @PostMapping("/guardar")
//    public String guardarVeterinario(@ModelAttribute @Valid VeterinarioDto veterinarioDto, Model model) {
//        try {
//            veterinarioService.saveVeterinario(veterinarioDto);
//            return "redirect:/veterinarios/form?exito";
//        } catch (IllegalArgumentException e) {
//            model.addAttribute("error", e.getMessage());
//            return "veterinario-form";
//        }
//    }
//
//    @ResponseBody
//    @GetMapping("/api")
//    public List<Veterinario> obtenerTodos() {
//        return veterinarioService.findAll();
//    }
//
//    @ResponseBody
//    @GetMapping("/api/{id}")
//    public ResponseEntity<Veterinario> obtenerPorId(@PathVariable Integer id) {
//        Optional<Veterinario> veterinario = veterinarioService.findById(id);
//        return veterinario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}

package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.VeterinarioDto;
import com.gestionviajes.msgestionviajes.model.Veterinario;
import com.gestionviajes.msgestionviajes.service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/veterinarios")
@RequiredArgsConstructor
public class ControllerVeterinario {

    private final VeterinarioService veterinarioService;

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("veterinarioDto", new VeterinarioDto());
        return "veterinario-form"; // apunta a templates/veterinario-form.html
    }

    @PostMapping("/guardar")
    public String guardarVeterinario(@ModelAttribute @Valid VeterinarioDto veterinarioDto, Model model) {
        try {
            veterinarioService.saveVeterinario(veterinarioDto);
            return "redirect:/veterinarios/form?exito";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "veterinario-form";
        }
    }

    // Opcional: REST para pruebas
    @ResponseBody
    @GetMapping("/api")
    public List<Veterinario> obtenerTodos() {
        return veterinarioService.findAll();
    }

    @ResponseBody
    @GetMapping("/api/{id}")
    public ResponseEntity<Veterinario> obtenerPorId(@PathVariable Integer id) {
        Optional<Veterinario> veterinario = veterinarioService.findById(id);
        return veterinario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
