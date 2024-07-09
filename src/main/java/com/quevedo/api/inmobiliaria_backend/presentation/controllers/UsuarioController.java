package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.create.IUsuarioCreateUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.deleteById.IUsuarioDeleteByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.readAll.IUsuarioReadAllUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.readById.IUsuarioReadByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.update.IUsuarioUpdateUseCase;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ResponseDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    private final IUsuarioCreateUseCase usuarioCreateUseCase;
    private final IUsuarioUpdateUseCase usuarioUpdateUseCase;
    private final IUsuarioReadAllUseCase usuarioReadAllUseCase;
    private final IUsuarioReadByIdUseCase usuarioReadByIdUseCase;
    private final IUsuarioDeleteByIdUseCase usuarioDeleteByIdUseCase;

    public UsuarioController(IUsuarioCreateUseCase usuarioCreateUseCase, IUsuarioUpdateUseCase usuarioUpdateUseCase, IUsuarioReadAllUseCase usuarioReadAllUseCase, IUsuarioReadByIdUseCase usuarioReadByIdUseCase, IUsuarioDeleteByIdUseCase usuarioDeleteByIdUseCase) {
        this.usuarioCreateUseCase = usuarioCreateUseCase;
        this.usuarioUpdateUseCase = usuarioUpdateUseCase;
        this.usuarioReadAllUseCase = usuarioReadAllUseCase;
        this.usuarioReadByIdUseCase = usuarioReadByIdUseCase;
        this.usuarioDeleteByIdUseCase = usuarioDeleteByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> readAll() {
        return ResponseEntity.ok(usuarioReadAllUseCase.execute());
    }

    @GetMapping(value = "/{idUsuario}")
    public ResponseEntity<ResponseDTO<UsuarioDTO>> readById(@PathVariable int idUsuario) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, usuarioReadByIdUseCase.execute(idUsuario)));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<UsuarioDTO>> create(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.CREATED, usuarioCreateUseCase.execute(usuarioCreateDTO)));
    }

    @PutMapping(value = "/{idUsuario}")
    public ResponseEntity<ResponseDTO<UsuarioDTO>> update(@PathVariable int idUsuario, @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, usuarioUpdateUseCase.execute(idUsuario, usuarioDTO)));
    }

    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity<ResponseDTO<Void>> delete(@PathVariable int idUsuario) {
        usuarioDeleteByIdUseCase.execute(idUsuario);
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.NO_CONTENT));
    }
}
