package com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class UsuarioUserDetailsDTO implements UserDetails {
    private Integer idUsuario;
    private String username;
    private String password;
    private String rol;
    private int equipoVenta;
    private LocalDateTime fechaRegistro;
    private boolean estado;

    // constructor
    public UsuarioUserDetailsDTO() {}

    public UsuarioUserDetailsDTO(Integer idUsuario, String username, String password, String rol, int equipoVenta, LocalDateTime fechaRegistro, boolean estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.equipoVenta = equipoVenta;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + rol));
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
}
