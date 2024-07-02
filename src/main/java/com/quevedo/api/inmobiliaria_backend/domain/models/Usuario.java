package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public record Usuario(
        Integer idUsuario,
        String username,
        String password,
        String rol,
        int equipoVenta,
        LocalDateTime fechaRegistro,
        boolean estado,
        Empleado empleado
) {
    public Usuario(String username, String password, String rol, int equipoVenta, LocalDateTime fechaRegistro, boolean estado, Empleado empleado) {
        this(null, username, password, rol, equipoVenta, fechaRegistro, estado, empleado);
    }
}
