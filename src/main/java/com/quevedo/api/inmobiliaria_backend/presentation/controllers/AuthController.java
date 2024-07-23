package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.auth.login.ILoginUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.auth.usuario.IGetUserAuthCaseUse;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ResponseDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginRequestDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginResponseDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    private final ILoginUseCase loginUseCase;
    private final IGetUserAuthCaseUse getUserAuthCaseUse;

    public AuthController(ILoginUseCase loginUseCase, IGetUserAuthCaseUse getUserAuthCaseUse) {
        this.loginUseCase = loginUseCase;
        this.getUserAuthCaseUse = getUserAuthCaseUse;
    }

    @GetMapping(value = "/perfil/{username}")
    public ResponseEntity<ResponseDTO<UsuarioDTO>> perfil(@PathVariable String username) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, getUserAuthCaseUse.execute(username)));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseDTO<LoginResponseDTO>> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, loginUseCase.execute(loginRequestDTO)));
    }
}
