package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.create;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;

public interface IClienteCreateUseCase {
    ClienteDTO execute(ClienteCreateDTO data);
}
