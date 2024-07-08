package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readById;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;

public interface IClienteReadByIdUseCase {
    ClienteDTO execute(int id);
}
