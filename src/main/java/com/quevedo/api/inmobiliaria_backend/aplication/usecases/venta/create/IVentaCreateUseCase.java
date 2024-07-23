package com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.create;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;

public interface IVentaCreateUseCase {
    VentaDTO execute(VentaCreateDTO data);
}
