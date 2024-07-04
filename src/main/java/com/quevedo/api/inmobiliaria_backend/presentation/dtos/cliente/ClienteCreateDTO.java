package com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;

public class ClienteCreateDTO {
    String nombre;
    String apellido;
    String DNI;
    String telefono;
    String email;
    String fechaRegistro;
    String tipoEstado;
    boolean estado;
    Usuario usuario;

    // constructor

    public ClienteCreateDTO(String nombre, String apellido, String DNI, String telefono, String email, String fechaRegistro, String tipoEstado, boolean estado, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.tipoEstado = tipoEstado;
        this.estado = estado;
        this.usuario = usuario;
    }

    //getters and setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
