package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.update;

import com.quevedo.api.inmobiliaria_backend.domain.models.Cliente;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IVentaRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.VentaMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VentaUpdateUseCase implements IVentaUpdateUseCase{

    private final IVentaRepository ventaRepository;
    private final IClienteRepository clienteRepository;

    public VentaUpdateUseCase(IVentaRepository ventaRepository, IClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public VentaDTO execute(int id, VentaDTO dto) {

        Optional<VentaEntity> opt = ventaRepository.readById(id);
        if(opt.isPresent()) {
            Optional<Cliente> cliEntity = clienteRepository.readById(opt.get().getCliente().getIdCliente());
            VentaEntity venta = ventaRepository.save(
                    new VentaEntity(
                            id,
                            opt.get().getUsuario(),
                            ClienteMapper.toEntity(cliEntity.get()),
                            dto.getLote(),
                            dto.getTipoLote(),
                            LocalDateTime.parse(dto.getFechaVenta()),
                            dto.getDetalles()
                    )
            );
            return VentaMapper.fromEntityToDto(venta);
        }
        throw new EntityNotFoundException();
    }
}
