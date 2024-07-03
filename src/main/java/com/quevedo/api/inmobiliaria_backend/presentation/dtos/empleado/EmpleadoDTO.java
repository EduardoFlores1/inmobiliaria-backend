package com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.contrato.ContratoDTO;

public class EmpleadoDTO {
    private Integer idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private String DNI;
    private String telefono;
    private String direccion;
    private String fechaContratacion;
    private String cargo;
    private boolean estado;
    private ContratoDTO contratoDTO;

    // constructor

    public EmpleadoDTO(Integer idEmpleado, String nombre, String apellido, String email, String DNI, String telefono, String direccion, String fechaContratacion, String cargo, boolean estado, ContratoDTO contratoDTO) {
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
        this.contratoDTO = contratoDTO;
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

    public ContratoDTO getContratoDTO() {
        return contratoDTO;
    }

    public void setContratoDTO(ContratoDTO contratoDTO) {
        this.contratoDTO = contratoDTO;
    }
}
