package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.update;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

public interface IUsuarioUpdateUseCase {
    UsuarioDTO execute(int id, UsuarioDTO usuarioDTO);
}
