package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;

import java.time.LocalDateTime;

public class ClienteMapper {
    public static Cliente fromEntity(ClienteEntity entity) {
        return new Cliente(
                entity.getIdCliente(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getDNI(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getFechaRegistro(),
                entity.getTipoEstado(),
                entity.isEstado(),
                UsuarioMapper.fromEntity(entity.getUsuario())
        );
    }

    public static ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDNI(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getFechaRegistro(),
                cliente.getTipoEstado(),
                cliente.isEstado(),
                UsuarioMapper.toEntity(cliente.getUsuario())
        );
    }

    public static ClienteDTO toResponse(Cliente cliente) {
        return new ClienteDTO(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDNI(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getFechaRegistro().toString(),
                cliente.getTipoEstado(),
                cliente.isEstado()
        );
    }

    public static Cliente fromDtoToCliente(ClienteDTO dto, Usuario usuario) {
        return new Cliente(
                dto.getIdCliente(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getDNI(),
                dto.getTelefono(),
                dto.getEmail(),
                LocalDateTime.parse(dto.getFechaRegistro()),
                dto.getTipoEstado(),
                dto.isEstado(),
                usuario
        );
    }
}
