package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.update;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteUpdateUseCase implements IClienteUpdateUseCase {

    private final IClienteRepository clienteRepository;

    public ClienteUpdateUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public ClienteDTO execute(int idCliente, ClienteDTO clienteDTO) {
        // if cliente exist
        Optional<Cliente> opt = clienteRepository.readById(idCliente);
        if (opt.isPresent()) {
            clienteDTO.setIdCliente(idCliente);
            Cliente clienteUpdate = clienteRepository.save(
                    ClienteMapper.fromDtoToCliente(clienteDTO, opt.get().getUsuario())
            );
            return ClienteMapper.toResponse(clienteUpdate);

        }
        throw new EntityNotFoundException();
    }
}
