package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.deleteById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteDeleteByIdUseCase implements IClienteDeleteByIdUseCase{

    private final IClienteRepository clienteRepository;

    public ClienteDeleteByIdUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public void execute(int id) {
        // if cliente exist
        Optional<Cliente> opt = clienteRepository.readById(id);
        if (opt.isPresent()) {
            // logic delete cliente
            opt.get().setEstado(false);
            clienteRepository.save(opt.get());
            return;
        }
        throw new EntityNotFoundException();
    }
}
