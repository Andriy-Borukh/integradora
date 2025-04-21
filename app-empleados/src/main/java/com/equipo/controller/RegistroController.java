package com.equipo.controller;

import com.equipo.model.dto.EmpleadoDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class RegistroController {

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("empleado", new EmpleadoDTO());
        return "registro";
    }


    @PostMapping("/registro")
    public String procesarFormularioRegistro(
            @Valid @ModelAttribute("empleado") EmpleadoDTO empleado,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("empleado", empleado);
            return "registro";
        }
        return "registro-exito";
    }
}


    /* Controlador para http://localhost:8080/registro
    y cargue la vista registro.html */
