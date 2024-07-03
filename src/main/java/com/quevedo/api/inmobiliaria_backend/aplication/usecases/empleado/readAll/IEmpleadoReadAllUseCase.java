package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.readAll;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoReadAllUseCase {
    List<EmpleadoDTO> execute();
}
