package com.quevedo.api.inmobiliaria_backend.domain.models;

import java.time.LocalDateTime;

public class Contrato{
    private Integer idContrato;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String tipoContrato;
    private Empleado empleado;

    // constructores

    public Contrato() {}

    public Contrato(Integer idContrato, LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoContrato, Empleado empleado) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
        this.empleado = empleado;
    }

    public Contrato(LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoContrato, Empleado empleado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
        this.empleado = empleado;
    }

    // getters and setters


    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
