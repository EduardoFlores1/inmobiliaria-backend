package com.quevedo.api.inmobiliaria_backend.config.security.filter;

import com.quevedo.api.inmobiliaria_backend.aplication.services.auth.IJwtService;
import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.helpers.PasswordHasher;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioUserDetailsDTO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;
    private final IUsuarioRepository usuarioRepository;

    public JwtAuthenticationFilter(IJwtService jwtService, IUsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1 obtener el header que contiene el jwt
        String authHeader = request.getHeader("Authorization");
        // 2 obtener el jwt del header
        String jwtToken = null;
        if (authHeader != null) {
            jwtToken = authHeader.split(" ")[1];
        }

        if (jwtToken != null) {
            // 3 obtener el subject/username del jwt
            String username = jwtService.extractUsername(jwtToken);
            Optional<Usuario> opt = usuarioRepository.findByUsername(username);
            if(opt.isPresent()) {
                UsuarioUserDetailsDTO usuarioUserDetailsDTO = UsuarioMapper.toUserDetails(opt.get());
                // 4 setear un objeto Authentication dentro del SecurityContext
                UsernamePasswordAuthenticationToken authToken =new UsernamePasswordAuthenticationToken(
                        username, null, usuarioUserDetailsDTO.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }else {
                SecurityContextHolder.clearContext();
            }

        }
        filterChain.doFilter(request, response);
    }
}
