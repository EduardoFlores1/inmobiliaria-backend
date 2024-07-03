package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.create.IEmpleadoCreateUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.deleteById.IEmpleadoDeleteByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.readAll.IEmpleadoReadAllUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.readById.IEmpleadoReadByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.update.IEmpleadoUpdateUseCase;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadoController {

    private final IEmpleadoCreateUseCase empleadoCreateUseCase;
    private final IEmpleadoReadAllUseCase empleadoReadAllUseCase;
    private final IEmpleadoReadByIdUseCase empleadoReadByIdUseCase;
    private final IEmpleadoUpdateUseCase empleadoUpdateUseCase;
    private final IEmpleadoDeleteByIdUseCase empleadoDeleteByIdUseCase;

    public EmpleadoController(IEmpleadoCreateUseCase empleadoCreateUseCase, IEmpleadoReadAllUseCase empleadoReadAllUseCase, IEmpleadoReadByIdUseCase empleadoReadByIdUseCase, IEmpleadoUpdateUseCase empleadoUpdateUseCase, IEmpleadoDeleteByIdUseCase empleadoDeleteByIdUseCase) {
        this.empleadoCreateUseCase = empleadoCreateUseCase;
        this.empleadoReadAllUseCase = empleadoReadAllUseCase;
        this.empleadoReadByIdUseCase = empleadoReadByIdUseCase;
        this.empleadoUpdateUseCase = empleadoUpdateUseCase;
        this.empleadoDeleteByIdUseCase = empleadoDeleteByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> readAll() {
        return ResponseEntity.ok(empleadoReadAllUseCase.execute());
    }

    @GetMapping(value = "/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO> readById(@PathVariable int idEmpleado) {
        return ResponseEntity.ok(empleadoReadByIdUseCase.execute(idEmpleado));
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> create(@RequestBody EmpleadoCreateDTO empleadoCreateDTO) {
        return new ResponseEntity<>(empleadoCreateUseCase.execute(empleadoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO> create(@PathVariable int idEmpleado, @RequestBody EmpleadoDTO empleadoDTO) {
        return ResponseEntity.ok(empleadoUpdateUseCase.execute(idEmpleado, empleadoDTO));
    }

    @DeleteMapping(value = "/{idEmpleado}")
    public ResponseEntity<Void> delete(@PathVariable int idEmpleado) {
        empleadoDeleteByIdUseCase.execute(idEmpleado);
        return ResponseEntity.ok().build();
    }
}
