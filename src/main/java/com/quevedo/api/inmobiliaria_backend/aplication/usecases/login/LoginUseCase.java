package com.quevedo.api.inmobiliaria_backend.aplication.usecases.login;

import com.quevedo.api.inmobiliaria_backend.aplication.services.auth.IJwtService;
import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginRequestDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.login.LoginResponseDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase implements ILoginUseCase{

    private final AuthenticationManager authenticationManager;
    private final IUsuarioRepository usuarioRepository;
    private final IJwtService jwtService;

    public LoginUseCase(AuthenticationManager authenticationManager, IUsuarioRepository usuarioRepository, IJwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponseDTO execute(LoginRequestDTO loginRequestDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(), loginRequestDTO.getPassword()
        );

        // ya definimos el auth provider con daoProvider
        authenticationManager.authenticate(authenticationToken);

        Usuario usuario = usuarioRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String jwt = jwtService.generateToken(usuario);

        return new LoginResponseDTO(
                "Bearer",
                jwt
        );
    }
}
