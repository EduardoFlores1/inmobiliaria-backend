package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;

public class VentaMapper {

    public static VentaDTO fromEntityToDto(VentaEntity entity) {
        return new VentaDTO(
                entity.getIdVenta(),
                UsuarioMapper.toResponse(UsuarioMapper.fromEntity(entity.getUsuario())),
                ClienteMapper.fromEntity(entity.getCliente()),
                entity.getLote(),
                entity.getTipoLote(),
                entity.getFechaVenta().toString(),
                entity.getDetalles()
        );
    }
}
