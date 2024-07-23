package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.readById;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;

public interface IVentaReadByIdUseCase {
    VentaDTO execute(int id);
}
