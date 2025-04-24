package com.equipo.controller;

import com.equipo.model.dto.LoginPaso1DTO;
import com.equipo.model.dto.LoginPaso2DTO;
import com.equipo.model.dto.LoginPaso3DTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginResumenController {

    @GetMapping("/login/resumen")
    public String mostrarResumen(HttpSession session, Model model) {

        LoginPaso1DTO paso1 = (LoginPaso1DTO) session.getAttribute("loginPaso1");
        LoginPaso2DTO paso2 = (LoginPaso2DTO) session.getAttribute("loginPaso2");
        LoginPaso3DTO paso3 = (LoginPaso3DTO) session.getAttribute("loginPaso3");

        model.addAttribute("loginPaso1", paso1);
        model.addAttribute("loginPaso2", paso2);
        model.addAttribute("loginPaso3", paso3);

        return "login/resumen";
    }
}
