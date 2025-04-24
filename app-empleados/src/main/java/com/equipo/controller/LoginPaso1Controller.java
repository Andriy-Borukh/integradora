package com.equipo.controller;

import com.equipo.model.dto.LoginPaso1DTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPaso1Controller {

    @GetMapping("/login/paso1")
    public String mostrarFormulario(Model model) {
        model.addAttribute("loginPaso1", new LoginPaso1DTO());
        model.addAttribute("mostrarErrores", false);
        return "login/paso1";
    }

    @PostMapping("/login/paso1")
    public String procesarFormulario(@Valid @ModelAttribute("loginPaso1") LoginPaso1DTO datos,
                                     BindingResult result,
                                     Model model,
                                     HttpSession session) {

        if (result.hasErrors()) {
            model.addAttribute("loginPaso1", datos);
            model.addAttribute("mostrarErrores", true);
            return "login/paso1";
        }

        session.setAttribute("loginPaso1", datos);
        return "redirect:/login/paso2";
    }
}
