package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.update;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

public interface IEmpleadoUpdateUseCase {
    EmpleadoDTO execute(int idEmpleado, EmpleadoDTO empleadoDTO);
}
