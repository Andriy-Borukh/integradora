package com.equipo.controller;

import com.equipo.model.dto.LoginPaso2DTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPaso2Controller {

    @GetMapping("/login/paso2")
    public String mostrarFormulario(Model model) {
        model.addAttribute("loginPaso2", new LoginPaso2DTO());
        model.addAttribute("mostrarErrores", false);
        return "login/paso2";
    }

    @PostMapping("/login/paso2")
    public String procesarFormulario(@Valid @ModelAttribute("loginPaso2") LoginPaso2DTO datos,
                                     BindingResult result,
                                     Model model,
                                     HttpSession session) {

        if (result.hasErrors()) {
            model.addAttribute("loginPaso2", datos);
            model.addAttribute("mostrarErrores", true);
            return "login/paso2";
        }

        session.setAttribute("loginPaso2", datos);
        return "redirect:/login/paso3";
    }
}
