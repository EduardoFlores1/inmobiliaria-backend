package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.readById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioReadByIdUseCase implements IUsuarioReadByIdUseCase{

    private final IUsuarioRepository usuarioRepository;

    public UsuarioReadByIdUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO execute(int id) {
        // if usuario exist
        Optional<Usuario> opt = usuarioRepository.readById(id);
        if(opt.isPresent()) {
            //  empleadoDTO
            return UsuarioMapper.toResponse(opt.get());
        }

        throw  new RuntimeException("El id del usuario no existe");
    }
}
