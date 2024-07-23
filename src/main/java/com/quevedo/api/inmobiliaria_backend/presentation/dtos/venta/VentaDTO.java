package com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.LoteEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.TipoLoteEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

public class VentaDTO {
    private Integer idVenta;
    private UsuarioDTO usuario;
    private Cliente cliente;
    private LoteEntity lote;
    private TipoLoteEntity tipoLote;
    private String fechaVenta;
    private String detalles;

    // constructor
    public VentaDTO() {}

    public VentaDTO(Integer idVenta, UsuarioDTO usuario, Cliente cliente, LoteEntity lote, TipoLoteEntity tipoLote, String fechaVenta, String detalles) {
        this.idVenta = idVenta;
        this.usuario = usuario;
        this.cliente = cliente;
        this.lote = lote;
        this.tipoLote = tipoLote;
        this.fechaVenta = fechaVenta;
        this.detalles = detalles;
    }

    // getters and setters

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
