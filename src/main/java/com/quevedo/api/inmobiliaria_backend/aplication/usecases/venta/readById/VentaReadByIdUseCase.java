package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.readById;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.IVentaRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.VentaMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VentaReadByIdUseCase implements IVentaReadByIdUseCase {

    private final IVentaRepository ventaRepository;

    public VentaReadByIdUseCase(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public VentaDTO execute(int id) {
        // if usuario exist
        Optional<VentaEntity> opt = ventaRepository.readById(id);
        if(opt.isPresent()) {
            //  empleadoDTO
            return VentaMapper.fromEntityToDto(opt.get());

        }
        throw  new EntityNotFoundException();
    }
}
