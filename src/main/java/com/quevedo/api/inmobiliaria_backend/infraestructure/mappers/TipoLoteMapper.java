package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.TipoLoteEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.tipoLote.TipoLoteDTO;

public class TipoLoteMapper {
    public static TipoLoteDTO fromEntityToDto(TipoLoteEntity entity) {
        return new TipoLoteDTO(
                entity.getIdTipoLote(),
                entity.getTipoPago(),
                entity.getDescripcion()
        );
    }
}
