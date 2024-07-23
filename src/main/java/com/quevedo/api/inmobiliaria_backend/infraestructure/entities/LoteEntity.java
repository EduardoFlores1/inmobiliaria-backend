package com.quevedo.api.inmobiliaria_backend.infraestructure.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity
@Table(name = "Lotes")
public class LoteEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Lote")
    private Integer idLote;

    @Column(name = "Manzana", nullable = false, unique = true)
    private String manzana;

    @Column(name = "Precio", nullable = false)
    private int precio;

    @Column(name = "Fecha_Ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name = "Tipo_Estado", nullable = false)
    private String tipoEstado;

    @Column(name = "Estado", nullable = false)
    private boolean estado;

    // constructor

    public LoteEntity() {
    }

    public LoteEntity(Integer idLote, String manzana, int precio, LocalDateTime fechaIngreso, String tipoEstado, boolean estado) {
        this.idLote = idLote;
        this.manzana = manzana;
        this.precio = precio;
        this.fechaIngreso = fechaIngreso;
        this.tipoEstado = tipoEstado;
        this.estado = estado;
    }

    // getters and setters

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
}
