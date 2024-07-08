package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.create;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UsuarioCreateUseCase implements IUsuarioCreateUseCase {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioCreateUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public UsuarioDTO execute(UsuarioCreateDTO data) {
        // create usuario
        try {
            Usuario usuario = usuarioRepository.save(
                    new Usuario(
                            data.getUsername(),
                            data.getPassword(),
                            data.getRol(),
                            data.getEquipoVenta(),
                            LocalDateTime.parse(data.getFechaRegistro()),
                            data.isEstado(),
                            EmpleadoMapper.fromDtoToEmpleado(data.getEmpleadoDTO())
                    )
            );
            return UsuarioMapper.toResponse(usuario);

        }catch (Exception e){
            throw new RuntimeException("Error al crear el usuario", e);
        }
    }
}
