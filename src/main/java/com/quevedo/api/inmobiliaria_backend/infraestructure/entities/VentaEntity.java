package com.quevedo.api.inmobiliaria_backend.infraestructure.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ventas")
public class VentaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Venta")
    private Integer idVenta;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_usuario"))
    private UsuarioEntity usuario;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_cliente"))
    private ClienteEntity cliente;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Lote", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_lote"))
    private LoteEntity lote;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Tipo_Lote", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_tipolote"))
    private TipoLoteEntity tipoLote;

    @Column(name = "Fecha_Venta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "Detalles", nullable = false)
    private String detalles;

    // constructor
    public VentaEntity() {}

    public VentaEntity(Integer idVenta, UsuarioEntity usuario, ClienteEntity cliente, LoteEntity lote, TipoLoteEntity tipoLote, LocalDateTime fechaVenta, String detalles) {
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

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
