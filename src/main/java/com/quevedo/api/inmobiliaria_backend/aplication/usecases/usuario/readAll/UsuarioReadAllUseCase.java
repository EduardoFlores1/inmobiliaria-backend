package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.readAll;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsuarioReadAllUseCase implements IUsuarioReadAllUseCase{

    private final IUsuarioRepository usuarioRepository;

    public UsuarioReadAllUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> execute() {
        // list all usuarios
        List<Usuario> list = usuarioRepository.readAll();
        return list.stream()
                .map(UsuarioMapper::toResponse).toList();
    }
}
