package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.otros;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.IClienteRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.ILoteRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.ITipoLoteRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.ClienteMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.LoteMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.TipoLoteMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.lote.LoteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.tipoLote.TipoLoteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaOtrosUseCase implements IVentaOtrosUseCase{

    private final IClienteRepository clienteRepository;
    private final ILoteRepository loteRepository;
    private final ITipoLoteRepository tipoLoteRepository;

    public VentaOtrosUseCase(IClienteRepository clienteRepository, ILoteRepository loteRepository, ITipoLoteRepository tipoLoteRepository) {
        this.clienteRepository = clienteRepository;
        this.loteRepository = loteRepository;
        this.tipoLoteRepository = tipoLoteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> listClientes(boolean estado) {
        return clienteRepository.findAllByEstado(estado).stream()
                .map(ClienteMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoteDTO> listLotes(String tipoEstado) {
        return loteRepository.findAllByTipoEstado(tipoEstado).stream()
                .map(LoteMapper::fromEntityToDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoLoteDTO> listTiposLotes() {
        return tipoLoteRepository.readAll().stream()
                .map(TipoLoteMapper::fromEntityToDto).toList();
    }
}
