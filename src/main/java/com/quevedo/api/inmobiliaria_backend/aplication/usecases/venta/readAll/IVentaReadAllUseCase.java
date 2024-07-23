package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.readAll;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;

import java.util.List;

public interface IVentaReadAllUseCase {
    List<VentaDTO> execute();
}
