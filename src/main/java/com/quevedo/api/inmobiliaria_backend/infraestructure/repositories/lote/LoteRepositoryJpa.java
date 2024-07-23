package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.lote;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.ILoteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.LoteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoteRepositoryJpa implements ILoteRepository {

    private final ILoteRepositoryJpa loteRepository;

    public LoteRepositoryJpa(ILoteRepositoryJpa loteRepository) {
        this.loteRepository = loteRepository;
    }

    @Override
    public List<LoteEntity> readAll() {
        return loteRepository.findAll();
    }

    @Override
    public Optional<LoteEntity> readById(Integer id) {
        return loteRepository.findById(id);
    }

    @Override
    public LoteEntity save(LoteEntity loteEntity) {
        return loteRepository.save(loteEntity);
    }

    @Override
    public void delete(int id) {
        loteRepository.deleteById(id);
    }

    @Override
    public List<LoteEntity> findAllByTipoEstado(String tipoEstado) {
        return loteRepository.findAllByTipoEstado(tipoEstado);
    }
}
