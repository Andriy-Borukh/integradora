package com.equipo.controller;


import com.equipo.model.dto.DatosPersonalesDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@SessionAttributes("datosPersonales")
public class RegistroEmpleadoPaso1Controller {

    @GetMapping("/registro/empleado/paso1")
    public String mostrarFormulario(Model model) {
            model.addAttribute("datosPersonales", new DatosPersonalesDTO());

        return "registro/empleado/paso1";
    }

    @PostMapping("/registro/empleado/paso1")
    public String procesarFormulario(@Valid @ModelAttribute("datosPersonales") DatosPersonalesDTO datos,
                                     BindingResult result,
                                     Model model) {
        // Validaciones adicionales
        MultipartFile foto = datos.getFotografia();
        if (foto == null || foto.isEmpty()) {
            result.rejectValue("fotografia", "error.fotografia", "La fotografía es obligatoria.");
        } else if (!foto.getContentType().equals("image/jpeg") && !foto.getContentType().equals("image/gif")) {
            result.rejectValue("fotografia", "error.fotografia", "El formato debe ser jpg o gif.");
        } else if (foto.getSize() > 200 * 1024) {
            result.rejectValue("fotografia", "error.fotografia", "La imagen no debe superar los 200 KB.");
        }

        if (!datos.edadCorrecta()) {
            result.rejectValue("edad", "error.edad", "La edad no coincide con la fecha de nacimiento o es menor de 18 años.");
        }

        if (result.hasErrors()) {
            model.addAttribute("datosPersonales", datos);
            return "registro/empleado/paso1";
        }

        return "redirect:/registro/empleado/paso2";
    }
}
