package com.quevedo.api.inmobiliaria_backend.infraestructure.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuarios")
public class UsuarioEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Integer idUsuario;

    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Rol", nullable = false)
    private String rol;

    @Column(name = "Equipo_Venta", nullable = true)
    private int equipoVenta;

    @Column(name = "Fecha_Registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Estado", nullable = false)
    private boolean estado;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Empleado", nullable = false, foreignKey = @ForeignKey(name = "fk_usuario_empleado"))
    private EmpleadoEntity empleado;

    // constructor

    public UsuarioEntity(Integer idUsuario, String username, String password, String rol, int equipoVenta, LocalDateTime fechaRegistro, boolean estado, EmpleadoEntity empleado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.equipoVenta = equipoVenta;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.empleado = empleado;
    }

    public UsuarioEntity() {}

    // getters and setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEquipoVenta() {
        return equipoVenta;
    }

    public void setEquipoVenta(int equipoVenta) {
        this.equipoVenta = equipoVenta;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
}
