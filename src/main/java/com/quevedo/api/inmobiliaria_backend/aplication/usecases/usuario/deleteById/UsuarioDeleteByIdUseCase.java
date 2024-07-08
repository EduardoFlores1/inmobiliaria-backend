package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.deleteById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioDeleteByIdUseCase implements IUsuarioDeleteByIdUseCase{

    private final IUsuarioRepository usuarioRepository;

    public UsuarioDeleteByIdUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public void execute(int id) {
        // if usuario exist
        Optional<Usuario> opt = usuarioRepository.readById(id);

        if(opt.isPresent()) {
            // logic delete usuario
            opt.get().setEstado(false);
            try {
                usuarioRepository.save(opt.get());

            }catch (Exception e) {
                throw new RuntimeException("Error al eliminar el usuario", e);
            }
        }else {
            throw  new RuntimeException("No Eliminación, El id del usuario no existe");
        }


    }
}
