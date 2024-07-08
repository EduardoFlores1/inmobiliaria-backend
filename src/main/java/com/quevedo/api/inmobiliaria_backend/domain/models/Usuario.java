package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public class Usuario{
    private Integer idUsuario;
    private String username;
    private String password;
    private String rol;
    private int equipoVenta;
    private LocalDateTime fechaRegistro;
    private boolean estado;
    private Empleado empleado;

    // constructor
    public Usuario() {}

    public Usuario(Integer idUsuario, String username, String password, String rol, int equipoVenta, LocalDateTime fechaRegistro, boolean estado, Empleado empleado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.equipoVenta = equipoVenta;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.empleado = empleado;
    }

    public Usuario(String username, String password, String rol, int equipoVenta, LocalDateTime fechaRegistro, boolean estado, Empleado empleado) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.equipoVenta = equipoVenta;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.empleado = empleado;
    }

    // getters and setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
