package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;

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
                cliente.idCliente(),
                cliente.nombre(),
                cliente.apellido(),
                cliente.DNI(),
                cliente.telefono(),
                cliente.email(),
                cliente.fechaRegistro(),
                cliente.tipoEstado(),
                cliente.estado(),
                UsuarioMapper.toEntity(cliente.usuario())
        );
    }
}
