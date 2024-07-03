package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.readAll;

import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IContratoRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoReadAllUseCase implements IEmpleadoReadAllUseCase{

    private final IEmpleadoRepository empleadoRepository;
    private final IContratoRepository contratoRepository;

    public EmpleadoReadAllUseCase(IEmpleadoRepository empleadoRepository, IContratoRepository contratoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    public List<EmpleadoDTO> execute() {
        // list all empleados
        List<Empleado> empleados = empleadoRepository.readAll();
        // find contratos by idEmpleado and return List<EmpleadoDTO>
        return empleados.stream()
                .map(empleado -> {
                    return EmpleadoMapper.toResponse(empleado, contratoRepository.
                            buscarPorIdEmpleado(empleado.idEmpleado()).orElse(null));
                }).toList();
    }
}
