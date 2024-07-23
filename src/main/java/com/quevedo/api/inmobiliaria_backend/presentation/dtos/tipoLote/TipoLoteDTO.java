package com.quevedo.api.inmobiliaria_backend.presentation.dtos.tipoLote;

public class TipoLoteDTO {
    private Integer idTipoLote;
    private String tipoPago;
    private String descripcion;

    public TipoLoteDTO() {
    }

    public TipoLoteDTO(Integer idTipoLote, String tipoPago, String descripcion) {
        this.idTipoLote = idTipoLote;
        this.tipoPago = tipoPago;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoLote() {
        return idTipoLote;
    }

    public void setIdTipoLote(Integer idTipoLote) {
        this.idTipoLote = idTipoLote;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
