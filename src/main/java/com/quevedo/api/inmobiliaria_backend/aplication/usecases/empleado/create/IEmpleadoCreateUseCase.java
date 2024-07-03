package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.create;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

public interface IEmpleadoCreateUseCase {
    EmpleadoDTO execute(EmpleadoCreateDTO data);
}
