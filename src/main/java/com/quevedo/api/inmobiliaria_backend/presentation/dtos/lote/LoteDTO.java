package com.quevedo.api.inmobiliaria_backend.presentation.dtos.lote;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class LoteDTO {
    private Integer idLote;
    private String manzana;
    private int precio;
    private String fechaIngreso;
    private String tipoEstado;
    private boolean estado;

    public LoteDTO() {

    }

    public LoteDTO(Integer idLote, String manzana, int precio, String fechaIngreso, String tipoEstado, boolean estado) {
        this.idLote = idLote;
        this.manzana = manzana;
        this.precio = precio;
        this.fechaIngreso = fechaIngreso;
        this.tipoEstado = tipoEstado;
        this.estado = estado;
    }

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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
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
