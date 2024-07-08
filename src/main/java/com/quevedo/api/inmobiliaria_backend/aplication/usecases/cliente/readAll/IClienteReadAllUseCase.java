package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readAll;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;

import java.util.List;

public interface IClienteReadAllUseCase {
    List<ClienteDTO> execute();
}
