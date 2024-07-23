package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.readAll;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.IVentaRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.VentaMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaReadAllUseCase implements IVentaReadAllUseCase{

    private final IVentaRepository ventaRepository;

    public VentaReadAllUseCase(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VentaDTO> execute() {
        List<VentaEntity> list = ventaRepository.readAll();
        return list.stream().map(VentaMapper::fromEntityToDto).toList();
    }
}
