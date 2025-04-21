package com.equipo.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpleadoDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @Email(message = "Debe ser un email válido")
    private String email;

    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Past(message = "La fecha debe ser anterior a hoy")
    private java.time.LocalDate fechaNacimiento;

    // Paso 2
    @NotBlank(message = "El puesto es obligatorio")
    private String jobTitle;

    @NotBlank(message = "El departamento es obligatorio")
    private String department;

    private String boss;

    private java.time.LocalDate startDate;

    // Paso 3
    private org.springframework.web.multipart.MultipartFile archivo;

}

