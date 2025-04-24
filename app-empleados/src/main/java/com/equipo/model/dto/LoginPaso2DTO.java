package com.equipo.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginPaso2DTO {

    @NotBlank(message = "La etiqueta es obligatoria.")
    private String etiqueta;
}
