package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;

public class UsuarioMapper {
    public static Usuario fromEntity(UsuarioEntity entity) {
        return new Usuario(
                entity.getIdUsuario(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getRol(),
                entity.getEquipoVenta(),
                entity.getFechaRegistro(),
                entity.isEstado(),
                EmpleadoMapper.fromEntity(entity.getEmpleado())
        );
    }

    public static UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.idUsuario(),
                usuario.username(),
                usuario.password(),
                usuario.rol(),
                usuario.equipoVenta(),
                usuario.fechaRegistro(),
                usuario.estado(),
                EmpleadoMapper.toEntity(usuario.empleado())
        );
    }
}
