package com.quevedo.api.inmobiliaria_backend.domain.repositories;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.LoteEntity;

import java.util.List;

public interface ILoteRepository extends ICommonRepository<LoteEntity>{
    List<LoteEntity> findAllByTipoEstado(String tipoEstado);
}
