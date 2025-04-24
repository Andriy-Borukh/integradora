package com.equipo.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginPaso1DTO {

    @NotBlank(message = "El nombre de usuario o email es obligatorio.")
    @Email(message = "Debe ser un email válido.")
    private String email;
}
