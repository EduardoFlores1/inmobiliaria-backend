package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

import java.time.LocalDateTime;

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

    public static UsuarioDTO toResponse(Usuario usuario) {
        return new UsuarioDTO(
                usuario.idUsuario(),
                usuario.username(),
                usuario.password(),
                usuario.rol(),
                usuario.equipoVenta(),
                usuario.fechaRegistro().toString(),
                usuario.estado(),
                EmpleadoMapper.toResponse(usuario.empleado(), null) //controlado en EmpleadoMapper
        );
    }

    public static Usuario fromDtoToUsuario(UsuarioDTO dto) {
        return new Usuario(
                dto.getIdUsuario(),
                dto.getUsername(),
                dto.getPassword(),
                dto.getRol(),
                dto.getEquipoVenta(),
                LocalDateTime.parse(dto.getFechaRegistro()),
                dto.isEstado(),
                EmpleadoMapper.fromDtoToEmpleado(dto.getEmpleadoDTO())
        );
    }
}
