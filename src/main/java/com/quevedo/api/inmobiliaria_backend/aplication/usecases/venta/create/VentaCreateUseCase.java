package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.create;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.IVentaRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.VentaMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class VentaCreateUseCase implements IVentaCreateUseCase{

    private final IVentaRepository ventaRepository;

    public VentaCreateUseCase(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    @Transactional
    public VentaDTO execute(VentaCreateDTO data) {
        VentaEntity venta = ventaRepository.save(
                new VentaEntity(
                        null,
                        data.getUsuario(),
                        data.getCliente(),
                        data.getLote(),
                        data.getTipoLote(),
                        LocalDateTime.parse(data.getFechaVenta()),
                        data.getDetalles()
                )
        );
        return VentaMapper.fromEntityToDto(venta);
    }
}
