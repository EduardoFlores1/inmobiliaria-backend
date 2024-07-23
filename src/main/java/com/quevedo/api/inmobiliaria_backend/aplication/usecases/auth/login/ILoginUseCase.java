package com.quevedo.api.inmobiliaria_backend.aplication.usecases.auth.login;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginRequestDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginResponseDTO;

public interface ILoginUseCase {
    LoginResponseDTO execute(LoginRequestDTO loginRequestDTO);
}
