package com.equipo.controller;

import com.equipo.model.dto.DatosContactoDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroEmpleadoPaso2Controller {

    @GetMapping("/registro/empleado/paso2")
    public String mostrarFormulario(Model model) {
        model.addAttribute("datosContacto", new DatosContactoDTO());
        model.addAttribute("mostrarErrores", false);
        return "registro/empleado/paso2";
    }

    @PostMapping("/registro/empleado/paso2")
    public String procesarFormulario(@Valid @ModelAttribute("datosContacto") DatosContactoDTO datos,
                                     BindingResult result,
                                     Model model,
                                     HttpSession session) {

        // Validaciones adicionales (si las necesitas)
        if (result.hasErrors()) {
            model.addAttribute("datosContacto", datos);
            model.addAttribute("mostrarErrores", true);
            return "registro/empleado/paso2";
        }
        session.setAttribute("datosContacto", datos);

        return "redirect:/registro/empleado/paso3";
    }
}
