package com.quevedo.api.inmobiliaria_backend.presentation.dtos.contrato;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

public class ContratoCreateDTO {
    private String fechaInicio;
    private String fechaFin;
    private String tipoContrato;
    private EmpleadoDTO empleadoDTO;

    // getters and setters

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

    public EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
        this.empleadoDTO = empleadoDTO;
    }
}
