package com.equipo.controller;

import com.equipo.model.dto.LoginPaso3DTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPaso3Controller {

    @GetMapping("/login/paso3")
    public String mostrarFormulario(Model model) {
        model.addAttribute("loginPaso3", new LoginPaso3DTO());
        model.addAttribute("mostrarErrores", false);
        return "login/paso3";
    }

    @PostMapping("/login/paso3")
    public String procesarFormulario(@Valid @ModelAttribute("loginPaso3") LoginPaso3DTO datos,
                                     BindingResult result,
                                     Model model,
                                     HttpSession session) {

        if (result.hasErrors()) {
            model.addAttribute("loginPaso3", datos);
            model.addAttribute("mostrarErrores", true);
            return "login/paso3";
        }

        session.setAttribute("loginPaso3", datos);
        return "redirect:/login/resumen";
    }
}
