package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.LoteEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.lote.LoteDTO;

public class LoteMapper {
    public static LoteDTO fromEntityToDto(LoteEntity entity) {
        return new LoteDTO(
                entity.getIdLote(),
                entity.getManzana(),
                entity.getPrecio(),
                entity.getFechaIngreso().toString(),
                entity.getTipoEstado(),
                entity.isEstado()
        );
    }
}
