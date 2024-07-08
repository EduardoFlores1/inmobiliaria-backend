package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.readById;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

public interface IUsuarioReadByIdUseCase {
    UsuarioDTO execute(int id);
}
