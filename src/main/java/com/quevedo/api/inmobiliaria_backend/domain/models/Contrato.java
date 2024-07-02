package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public record Contrato(
        Integer idContrato,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        String tipoContrato,
        Empleado empleado
) {
    public Contrato(LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoContrato, Empleado empleado) {
        this(null, fechaInicio, fechaFin, tipoContrato, empleado);
    }
}
