package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.readById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IContratoRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpleadoReadByIdUseCase implements IEmpleadoReadByIdUseCase {

    private final IEmpleadoRepository empleadoRepository;
    private final IContratoRepository contratoRepository;

    public EmpleadoReadByIdUseCase(IEmpleadoRepository empleadoRepository, IContratoRepository contratoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoDTO execute(int id) {
        // if empleado exist
        Optional<Empleado> opt = empleadoRepository.readById(id);
        if (opt.isPresent()) {
            // get contrato
            Optional<Contrato> optContrato = contratoRepository.buscarPorIdEmpleado(id);

            // build empleadoDTO
            return EmpleadoMapper.toResponse(opt.get(), optContrato.orElse(null));
        }

        throw new EntityNotFoundException();
    }
}
