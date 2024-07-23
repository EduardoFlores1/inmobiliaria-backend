package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.otros;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.lote.LoteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.tipoLote.TipoLoteDTO;

import java.util.List;

public interface IVentaOtrosUseCase {
    List<ClienteDTO> listClientes(boolean estado);
    List<LoteDTO> listLotes(String tipoEstado);
    List<TipoLoteDTO> listTiposLotes();
}
