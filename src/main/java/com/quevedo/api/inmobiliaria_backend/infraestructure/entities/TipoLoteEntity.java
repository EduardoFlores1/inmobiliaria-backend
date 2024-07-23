package com.quevedo.api.inmobiliaria_backend.infraestructure.entities;

import jakarta.persistence.*;

import java.io.Serial;

@Entity
@Table(name = "Tipo_Lote")
public class TipoLoteEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tipo_Lote")
    private Integer idTipoLote;

    @Column(name = "Tipo_Pago", nullable = false, unique = true)
    private String tipoPago;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    // constructor
    public TipoLoteEntity() {}

    public TipoLoteEntity(Integer idTipoLote, String tipoPago, String descripcion) {
        this.idTipoLote = idTipoLote;
        this.tipoPago = tipoPago;
        this.descripcion = descripcion;
    }

    // getters and setters

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
