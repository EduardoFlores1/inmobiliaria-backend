package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.create.IClienteCreateUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readAll.IClienteReadAllUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readById.IClienteReadByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.update.IClienteUpdateUseCase;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    private final IClienteCreateUseCase clienteCreateUseCase;
    private final IClienteUpdateUseCase clienteUpdateUseCase;
    private final IClienteReadAllUseCase clienteReadAllUseCase;
    private final IClienteReadByIdUseCase clienteReadByIdUseCase;

    public ClienteController(IClienteCreateUseCase clienteCreateUseCase, IClienteUpdateUseCase clienteUpdateUseCase, IClienteReadAllUseCase clienteReadAllUseCase, IClienteReadByIdUseCase clienteReadByIdUseCase) {
        this.clienteCreateUseCase = clienteCreateUseCase;
        this.clienteUpdateUseCase = clienteUpdateUseCase;
        this.clienteReadAllUseCase = clienteReadAllUseCase;
        this.clienteReadByIdUseCase = clienteReadByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> readAll() {
        return ResponseEntity.ok(clienteReadAllUseCase.execute());
    }

    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<ClienteDTO> readById(@PathVariable int idCliente) {
        return ResponseEntity.ok(clienteReadByIdUseCase.execute(idCliente));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        return new ResponseEntity<>(clienteCreateUseCase.execute(clienteCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idCliente}")
    public ResponseEntity<ClienteDTO> create(@PathVariable int idCliente, @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteUpdateUseCase.execute(idCliente, clienteDTO));
    }
}
