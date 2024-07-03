package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.deleteById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IContratoRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpleadoDeleteByIdUseCase implements IEmpleadoDeleteByIdUseCase {

    private final IEmpleadoRepository empleadoRepository;
    private final IContratoRepository contratoRepository;

    public EmpleadoDeleteByIdUseCase(IEmpleadoRepository empleadoRepository, IContratoRepository contratoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    @Transactional
    public void execute(int id) {
        // if empleado exist
        Optional<Empleado> opt = empleadoRepository.readById(id);
        if (opt.isPresent()) {
            // get contrato
            Contrato contrato = contratoRepository.buscarPorIdEmpleado(id).orElse(null);

            // if contrato exist
            if(contrato != null) {
                contratoRepository.delete(contrato.idContrato());
            }

            // delete empleado
            empleadoRepository.delete(id);
        } else {
            throw new RuntimeException("No Eliminación, El id del empleado no existe");
        }

    }
}
