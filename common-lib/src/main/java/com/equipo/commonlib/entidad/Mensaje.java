package com.equipo.commonlib.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Contenido es obligatorio")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "remitente_id", nullable = false)
    private Empleado remitente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false)
    private Empleado destinatario;

    private LocalDateTime fechaEnvio;
}
