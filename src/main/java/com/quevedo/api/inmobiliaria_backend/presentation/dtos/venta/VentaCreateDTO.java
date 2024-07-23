package com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.LoteEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.TipoLoteEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;

public class VentaCreateDTO {
    private UsuarioEntity usuario;
    private ClienteEntity cliente;
    private LoteEntity lote;
    private TipoLoteEntity tipoLote;
    private String fechaVenta;
    private String detalles;

    // constructor

    public VentaCreateDTO() {
    }

    public VentaCreateDTO(UsuarioEntity usuario, ClienteEntity cliente, LoteEntity lote, TipoLoteEntity tipoLote, String fechaVenta, String detalles) {
        this.usuario = usuario;
        this.cliente = cliente;
        this.lote = lote;
        this.tipoLote = tipoLote;
        this.fechaVenta = fechaVenta;
        this.detalles = detalles;
    }

    // getters and setters

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public LoteEntity getLote() {
        return lote;
    }

    public void setLote(LoteEntity lote) {
        this.lote = lote;
    }

    public TipoLoteEntity getTipoLote() {
        return tipoLote;
    }

    public void setTipoLote(TipoLoteEntity tipoLote) {
        this.tipoLote = tipoLote;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
