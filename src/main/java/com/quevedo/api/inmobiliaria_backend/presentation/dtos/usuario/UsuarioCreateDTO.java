package com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

public class UsuarioCreateDTO {
    String username;
    String password;
    String rol;
    int equipoVenta;
    String fechaRegistro;
    boolean estado;
    EmpleadoDTO empleadoDTO;

    // cosntructor

    public UsuarioCreateDTO(String username, String password, String rol, int equipoVenta, String fechaRegistro, boolean estado, EmpleadoDTO empleadoDTO) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.equipoVenta = equipoVenta;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.empleadoDTO = empleadoDTO;
    }

    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEquipoVenta() {
        return equipoVenta;
    }

    public void setEquipoVenta(int equipoVenta) {
        this.equipoVenta = equipoVenta;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
        this.empleadoDTO = empleadoDTO;
    }
}
