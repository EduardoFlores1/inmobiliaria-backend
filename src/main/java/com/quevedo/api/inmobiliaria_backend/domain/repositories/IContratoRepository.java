package com.quevedo.api.inmobiliaria_backend.domain.repositories;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;

import java.util.Optional;

public interface IContratoRepository extends ICommonRepository<Contrato>{
    Optional<Contrato> buscarPorIdEmpleado(Integer idEmpleado);
}
