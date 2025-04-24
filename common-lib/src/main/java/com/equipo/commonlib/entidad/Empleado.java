package com.equipo.commonlib.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Email(message = "Email debe ser válido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Contraseña es obligatoria")
    private String password;

    @Embedded
    private Direccion direccion;

    @Builder.Default
    private boolean activo = true;

    @OneToMany(mappedBy = "empleado")
    private List<Nomina> nominas;

    @OneToMany(mappedBy = "remitente")
    private List<Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "destinatario")
    private List<Mensaje> mensajesRecibidos;

    @OneToMany(mappedBy = "solicitante")
    private List<Colaboracion> solicitudesEnviadas;

    @OneToMany(mappedBy = "receptor")
    private List<Colaboracion> solicitudesRecibidas;
}