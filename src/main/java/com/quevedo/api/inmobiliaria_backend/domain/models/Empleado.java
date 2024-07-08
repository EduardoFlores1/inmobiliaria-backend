package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public class Empleado{
    private Integer idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private String DNI;
    private String telefono;
    private String direccion;
    private LocalDateTime fechaContratacion;
    private String cargo;
    private boolean estado;

    // constructores

    public Empleado() {}

    public Empleado(Integer idEmpleado, String nombre, String apellido, String email, String DNI, String telefono, String direccion, LocalDateTime fechaContratacion, String cargo, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaContratacion = fechaContratacion;
        this.cargo = cargo;
        this.estado = estado;
    }

    public Empleado(String nombre, String apellido, String email, String DNI, String telefono, String direccion, LocalDateTime fechaContratacion, String cargo, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaContratacion = fechaContratacion;
        this.cargo = cargo;
        this.estado = estado;
    }

    // getters and setters

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
