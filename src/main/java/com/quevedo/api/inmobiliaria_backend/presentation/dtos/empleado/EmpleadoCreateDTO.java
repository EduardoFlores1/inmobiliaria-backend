package com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.contrato.ContratoCreateDTO;

public class EmpleadoCreateDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String DNI;
    private String telefono;
    private String direccion;
    private String fechaContratacion;
    private String cargo;
    private boolean estado;
    private ContratoCreateDTO contratoCreateDTO;

    // getters and setters

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

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
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

    public ContratoCreateDTO getContratoCreateDTO() {
        return contratoCreateDTO;
    }

    public void setContratoCreateDTO(ContratoCreateDTO contratoCreateDTO) {
        this.contratoCreateDTO = contratoCreateDTO;
    }
}
