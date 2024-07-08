package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readAll;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteReadAllUseCase implements IClienteReadAllUseCase{

    private final IClienteRepository clienteRepository;

    public ClienteReadAllUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> execute() {
        // list all clientes
        List<Cliente> list = clienteRepository.readAll();
        return list.stream()
                .map(ClienteMapper::toResponse).toList();
    }
}
