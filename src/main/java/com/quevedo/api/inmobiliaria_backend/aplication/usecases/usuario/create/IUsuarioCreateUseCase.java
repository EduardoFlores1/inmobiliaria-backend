package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.create;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

public interface IUsuarioCreateUseCase {
    UsuarioDTO execute(UsuarioCreateDTO data);
}
