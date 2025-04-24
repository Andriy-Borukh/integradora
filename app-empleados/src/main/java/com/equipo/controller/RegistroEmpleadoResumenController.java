package com.equipo.controller;

import com.equipo.model.dto.DatosContactoDTO;
import com.equipo.model.dto.DatosEconomicosDTO;
import com.equipo.model.dto.DatosPersonalesDTO;
import com.equipo.model.dto.DatosProfesionalesDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegistroEmpleadoResumenController {

    @GetMapping("/registro/empleado/resumen")
    public String mostrarResumen(HttpSession session, Model model) {
        model.addAttribute("datosPersonales", session.getAttribute("datosPersonales"));
        model.addAttribute("datosContacto", session.getAttribute("datosContacto"));
        model.addAttribute("datosProfesionales", session.getAttribute("datosProfesionales"));
        model.addAttribute("datosEconomicos", session.getAttribute("datosEconomicos"));
        return "registro/empleado/paso5";
    }
}
