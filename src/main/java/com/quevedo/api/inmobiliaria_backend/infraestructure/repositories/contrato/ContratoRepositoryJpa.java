package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.contrato;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IContratoRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ContratoEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ContratoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContratoRepositoryJpa implements IContratoRepository {

    private final IContratoRepositoryJpa contratoRepositoryJpa;

    public ContratoRepositoryJpa(IContratoRepositoryJpa contratoRepositoryJpa) {
        this.contratoRepositoryJpa = contratoRepositoryJpa;
    }

    @Override
    public List<Contrato> readAll() {
        return contratoRepositoryJpa.findAll().stream()
                .map(ContratoMapper::fromEntity).toList();
    }

    @Override
    public Optional<Contrato> readById(Integer id) {
        return contratoRepositoryJpa.findById(id).map(ContratoMapper::fromEntity);
    }

    @Override
    public Contrato save(Contrato contrato) {
        ContratoEntity entity = ContratoMapper.toEntity(contrato);
        return ContratoMapper.fromEntity(contratoRepositoryJpa.save(entity));
    }

    @Override
    public void delete(int id) {
        contratoRepositoryJpa.deleteById(id);
    }

    @Override
    public Optional<Contrato> buscarPorIdEmpleado(Integer idEmpleado) {
        return contratoRepositoryJpa.buscarPorIdEmpleado(idEmpleado).map(ContratoMapper::fromEntity);
    }
}
