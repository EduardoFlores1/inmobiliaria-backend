package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.tipoLote;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.TipoLoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoLoteRepositoryJpa extends JpaRepository<TipoLoteEntity, Integer> {
}
