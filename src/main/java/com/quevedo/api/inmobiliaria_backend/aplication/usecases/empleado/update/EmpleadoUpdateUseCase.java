package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.update;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IContratoRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ContratoMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpleadoUpdateUseCase implements IEmpleadoUpdateUseCase{

    private final IEmpleadoRepository empleadoRepository;
    private final IContratoRepository contratoRepository;

    public EmpleadoUpdateUseCase(IEmpleadoRepository empleadoRepository, IContratoRepository contratoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    @Transactional
    public EmpleadoDTO execute(int idEmpleado, EmpleadoDTO empleadoDTO) {
        // if empleado exist
        Optional<Empleado> opt = empleadoRepository.readById(idEmpleado);
        if (opt.isPresent()) {
            // update Empleado
                empleadoDTO.setIdEmpleado(idEmpleado);
                Empleado empleadoUpdate = empleadoRepository
                        .save(EmpleadoMapper.fromDtoToEmpleado(empleadoDTO));

                // update contrato
                Contrato contratoUpdate = contratoRepository
                        .save(ContratoMapper.fromDtoToContrato(empleadoUpdate, empleadoDTO.getContratoDTO()));

                return EmpleadoMapper.toResponse(empleadoUpdate, contratoUpdate);

        }
        throw new EntityNotFoundException();
    }
}
