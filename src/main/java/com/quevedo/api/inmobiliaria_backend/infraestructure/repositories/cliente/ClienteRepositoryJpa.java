package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.cliente;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryJpa implements IClienteRepository {

    private final IClienteRepositoryJpa clienteRepositoryJpa;

    public ClienteRepositoryJpa(IClienteRepositoryJpa clienteRepositoryJpa) {
        this.clienteRepositoryJpa = clienteRepositoryJpa;
    }

    @Override
    public List<Cliente> readAll() {
        return clienteRepositoryJpa.findAll().stream()
                .map(ClienteMapper::fromEntity).toList();
    }

    @Override
    public Optional<Cliente> readById(Integer id) {
        return clienteRepositoryJpa.findById(id).map(ClienteMapper::fromEntity);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = ClienteMapper.toEntity(cliente);
        return ClienteMapper.fromEntity(clienteRepositoryJpa.save(entity));
    }

    @Override
    public void delete(int id) {
        clienteRepositoryJpa.deleteById(id);
    }
}
