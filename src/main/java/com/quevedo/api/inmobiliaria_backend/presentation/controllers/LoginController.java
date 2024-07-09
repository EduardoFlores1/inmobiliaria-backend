package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.login.ILoginUseCase;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginRequestDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    private final ILoginUseCase loginUseCase;

    public LoginController(ILoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(loginUseCase.execute(loginRequestDTO));
    }
}
