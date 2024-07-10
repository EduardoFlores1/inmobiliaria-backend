package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioUserDetailsDTO;


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
                usuario.getIdUsuario(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol(),
                usuario.getEquipoVenta(),
                usuario.getFechaRegistro(),
                usuario.isEstado(),
                EmpleadoMapper.toEntity(usuario.getEmpleado())
        );
    }

    public static UsuarioDTO toResponse(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getUsername(),
                usuario.getRol(),
                usuario.getEquipoVenta(),
                usuario.getFechaRegistro().toString(),
                usuario.isEstado(),
                EmpleadoMapper.toResponse(usuario.getEmpleado(), null) //controlado en EmpleadoMapper
        );
    }

    /*public static Usuario fromDtoToUsuario(UsuarioDTO dto) {
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
    }*/

    public static UsuarioUserDetailsDTO toUserDetails(Usuario usuario) {
        return new UsuarioUserDetailsDTO(
                usuario.getIdUsuario(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol(),
                usuario.getEquipoVenta(),
                usuario.getFechaRegistro(),
                usuario.isEstado()
        );
    }
}
