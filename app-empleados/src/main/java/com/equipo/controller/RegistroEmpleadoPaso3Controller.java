package com.equipo.controller;

import com.equipo.model.dto.DatosProfesionalesDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroEmpleadoPaso3Controller {

    @GetMapping("/registro/empleado/paso3")
    public String mostrarFormulario(Model model) {
        model.addAttribute("datosProfesionales", new DatosProfesionalesDTO());
        model.addAttribute("mostrarErrores", false);
        return "registro/empleado/paso3";
    }

    @PostMapping("/registro/empleado/paso3")
    public String procesarFormulario(@Valid @ModelAttribute("datosProfesionales") DatosProfesionalesDTO datos,
                                     BindingResult result,
                                     Model model,
                                     HttpSession session) {

        if (result.hasErrors()) {
            model.addAttribute("datosProfesionales", datos);
            model.addAttribute("mostrarErrores", true);
            return "registro/empleado/paso3";
        }
        session.setAttribute("datosProfesionales", datos);

        return "redirect:/registro/empleado/paso4";
    }
}
