package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.tipoLote;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.ITipoLoteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.TipoLoteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoLoteRepositoryJpa implements ITipoLoteRepository {

    private final ITipoLoteRepositoryJpa tipoLoteRepository;

    public TipoLoteRepositoryJpa(ITipoLoteRepositoryJpa tipoLoteRepository) {
        this.tipoLoteRepository = tipoLoteRepository;
    }

    @Override
    public List<TipoLoteEntity> readAll() {
        return tipoLoteRepository.findAll();
    }

    @Override
    public Optional<TipoLoteEntity> readById(Integer id) {
        return tipoLoteRepository.findById(id);
    }

    @Override
    public TipoLoteEntity save(TipoLoteEntity tipoLoteEntity) {
        return tipoLoteRepository.save(tipoLoteEntity);
    }

    @Override
    public void delete(int id) {
        tipoLoteRepository.deleteById(id);
    }
}
