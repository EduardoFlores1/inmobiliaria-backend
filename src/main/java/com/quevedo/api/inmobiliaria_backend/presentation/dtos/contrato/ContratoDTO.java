package com.quevedo.api.inmobiliaria_backend.presentation.dtos.contrato;

public class ContratoDTO {
    private Integer idContrato;
    private String fechaInicio;
    private String fechaFin;
    private String tipoContrato;

    // constructor

    public ContratoDTO(Integer idContrato, String fechaInicio, String fechaFin, String tipoContrato) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
    }

    // getters and setters

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
