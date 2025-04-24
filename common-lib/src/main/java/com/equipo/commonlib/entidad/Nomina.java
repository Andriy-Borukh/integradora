package com.equipo.commonlib.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nominas")
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    @PastOrPresent(message = "Fecha debe ser actual o pasada")
    private LocalDate fecha;

    @OneToMany(mappedBy = "nomina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaNomina> lineas;

    @PositiveOrZero(message = "Total no puede ser negativo")
    private double total;
}
