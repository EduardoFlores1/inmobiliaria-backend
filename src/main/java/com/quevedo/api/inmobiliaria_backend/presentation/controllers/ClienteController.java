package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.create.IClienteCreateUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readAll.IClienteReadAllUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.readById.IClienteReadByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.cliente.update.IClienteUpdateUseCase;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ResponseDTO;
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
    public ResponseEntity<ResponseDTO<List<ClienteDTO>>> readAll() {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, clienteReadAllUseCase.execute()));
    }

    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<ResponseDTO<ClienteDTO>> readById(@PathVariable int idCliente) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, clienteReadByIdUseCase.execute(idCliente)));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ClienteDTO>> create(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.CREATED, clienteCreateUseCase.execute(clienteCreateDTO)));
    }

    @PutMapping(value = "/{idCliente}")
    public ResponseEntity<ResponseDTO<ClienteDTO>> update(@PathVariable int idCliente, @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, clienteUpdateUseCase.execute(idCliente, clienteDTO)));
    }
}
