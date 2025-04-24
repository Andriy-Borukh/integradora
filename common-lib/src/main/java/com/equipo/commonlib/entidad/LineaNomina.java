package com.equipo.commonlib.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lineas_nomina")
public class LineaNomina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Concepto es obligatorio")
    private String concepto;

    @Positive(message = "Cantidad debe ser positiva")
    private double cantidad;

    @ManyToOne
    @JoinColumn(name = "nomina_id", nullable = false)
    private Nomina nomina;
}