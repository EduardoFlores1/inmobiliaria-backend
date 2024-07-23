package com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.create;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ClienteCreateUseCase implements IClienteCreateUseCase {

    private final IClienteRepository clienteRepository;

    public ClienteCreateUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public ClienteDTO execute(ClienteCreateDTO data) {
        // create cliente
        Cliente cliente = clienteRepository.save(
                new Cliente(
                        data.getNombre(),
                        data.getApellido(),
                        data.getDNI(),
                        data.getTelefono(),
                        data.getEmail(),
                        LocalDateTime.parse(data.getFechaRegistro()),
                        data.getTipoEstado(),
                        data.isEstado(),
                        UsuarioMapper.fromDtoToUsuario(data.getUsuarioDTO())
                )
        );
        return ClienteMapper.toResponse(cliente);
    }
}
