package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.readById;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

public interface IEmpleadoReadByIdUseCase {
    EmpleadoDTO execute(int id);
}
