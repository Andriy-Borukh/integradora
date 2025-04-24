package com.equipo.controller;

import com.equipo.model.dto.DatosEconomicosDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroEmpleadoPaso4Controller {

    @GetMapping("/registro/empleado/paso4")
    public String mostrarFormulario(Model model) {
        model.addAttribute("datosEconomicos", new DatosEconomicosDTO());
        model.addAttribute("mostrarErrores", false);
        return "registro/empleado/paso4";
    }

    @PostMapping("/registro/empleado/paso4")
    public String procesarFormulario(@Valid @ModelAttribute("datosEconomicos") DatosEconomicosDTO datos,
                                     BindingResult result,
                                     Model model,
                                     HttpSession session) {

        if (result.hasErrors()) {
            model.addAttribute("datosEconomicos", datos);
            model.addAttribute("mostrarErrores", true);
            return "registro/empleado/paso4";
        }
        session.setAttribute("datosEconomicos", datos);

        return "redirect:/registro/empleado/resumen";
    }
}
