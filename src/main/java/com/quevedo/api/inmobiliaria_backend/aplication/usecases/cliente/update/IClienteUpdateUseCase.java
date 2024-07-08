package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.update;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;

public interface IClienteUpdateUseCase {
    ClienteDTO execute(int idCliente, ClienteDTO clienteDTO);
}
