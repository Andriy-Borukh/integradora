package com.equipo.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginPaso3DTO {

    @NotBlank(message = "La contraseña es obligatoria.")
    private String contrasena;
}
