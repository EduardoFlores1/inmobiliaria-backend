package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteReadByIdUseCase implements IClienteReadByIdUseCase {

    private final IClienteRepository clienteRepository;

    public ClienteReadByIdUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO execute(int id) {
        // if cliente exist
        Optional<Cliente> opt = clienteRepository.readById(id);
        if (opt.isPresent()) {
            return ClienteMapper.toResponse(opt.get());

        }
        throw new EntityNotFoundException();
    }
}
