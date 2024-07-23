package com.quevedo.api.inmobiliaria_backend.domain.repositories;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;

import java.util.List;

public interface IClienteRepository extends ICommonRepository<Cliente>{
    List<Cliente> findAllByEstado(boolean estado);
}
