package com.equipo.commonlib.entidad;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String pais;
}