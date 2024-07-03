package com.quevedo.api.inmobiliaria_backend.infraestructure.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Contratos")
public class ContratoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Contrato")
    private Integer idContrato;

    @Column(name = "Fecha_Inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "Fecha_Fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "Tipo_Contrato", nullable = false)
    private String tipoContrato;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Empleado", nullable = false, foreignKey = @ForeignKey(name = "fk_contrato_empleado"))
    private EmpleadoEntity empleado;

    // constructor

    public ContratoEntity(Integer idContrato, LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoContrato, EmpleadoEntity empleado) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
        this.empleado = empleado;
    }

    public ContratoEntity() {}

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

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
}
