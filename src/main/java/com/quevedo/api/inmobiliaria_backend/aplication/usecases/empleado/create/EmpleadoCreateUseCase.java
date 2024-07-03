package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.create;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IContratoRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmpleadoCreateUseCase implements IEmpleadoCreateUseCase{

    private final IEmpleadoRepository empleadoRepository;
    private final IContratoRepository contratoRepository;

    public EmpleadoCreateUseCase(IEmpleadoRepository empleadoRepository, IContratoRepository contratoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    @Transactional
    public EmpleadoDTO execute(EmpleadoCreateDTO data) {
        // create empleado
        Empleado empleado = empleadoRepository.save(
                new Empleado(
                        data.getNombre(),
                        data.getApellido(),
                        data.getEmail(),
                        data.getDNI(),
                        data.getTelefono(),
                        data.getDireccion(),
                        LocalDateTime.parse(data.getFechaContratacion()),
                        data.getCargo(),
                        data.isEstado()
                )
        );

        // anex create contrato
        Contrato contrato = contratoRepository.save(
                new Contrato(
                        LocalDateTime.parse(data.getContratoCreateDTO().getFechaInicio()),
                        LocalDateTime.parse(data.getContratoCreateDTO().getFechaFin()),
                        data.getContratoCreateDTO().getTipoContrato(),
                        empleado
                )
        );

        return EmpleadoMapper.toResponse(empleado, contrato);
    }
}
