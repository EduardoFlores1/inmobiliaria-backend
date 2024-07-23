package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.lote;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.LoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILoteRepositoryJpa extends JpaRepository<LoteEntity, Integer> {
    List<LoteEntity> findAllByTipoEstado(String tipoEstado);
}
