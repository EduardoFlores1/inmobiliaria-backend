package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public record Cliente(
        Integer idCliente,
        String nombre,
        String apellido,
        String DNI,
        String telefono,
        String email,
        LocalDateTime fechaRegistro,
        String tipoEstado,
        boolean estado,
        Usuario usuario
) {
    public Cliente(String nombre, String apellido, String DNI, String telefono, String email, LocalDateTime fechaRegistro, String tipoEstado, boolean estado, Usuario usuario) {
        this(null, nombre, apellido, DNI, telefono, email, fechaRegistro, tipoEstado, estado, usuario);
    }
}
