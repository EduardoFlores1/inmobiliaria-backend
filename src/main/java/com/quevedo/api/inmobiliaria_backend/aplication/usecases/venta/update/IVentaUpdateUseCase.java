package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.update;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;

public interface IVentaUpdateUseCase {
    VentaDTO execute(int id, VentaDTO dto);
}
