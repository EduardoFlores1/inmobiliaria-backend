package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.readAll;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;

import java.util.List;

public interface IUsuarioReadAllUseCase {
    List<UsuarioDTO> execute();
}
