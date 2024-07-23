package com.quevedo.api.inmobiliaria_backend.aplication.usecases.auth.usuario;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

public interface IGetUserAuthCaseUse {
    UsuarioDTO execute(String username);
}
