package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public record Empleado(
        Integer idEmpleado,
        String nombre,
        String apellido,
        String email,
        String DNI,
        String telefono,
        String direccion,
        LocalDateTime fechaContratacion,
        String cargo,
        boolean estado
) {
    public Empleado(String nombre, String apellido, String email, String DNI, String telefono, String direccion, LocalDateTime fechaContratacion, String cargo, boolean estado) {
        this(null, nombre, apellido, email, DNI, telefono, direccion, fechaContratacion, cargo, estado);
    }
}
