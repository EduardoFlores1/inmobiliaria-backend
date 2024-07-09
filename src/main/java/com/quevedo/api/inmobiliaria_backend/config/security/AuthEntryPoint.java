package com.quevedo.api.inmobiliaria_backend.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ErrorDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class AuthEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        ResponseDTO<ErrorDTO> responseDTO = ResponseDTO.of(HttpStatus.FORBIDDEN, ErrorDTO.of(1,"Acceso Denegado"));
        response.getWriter().write(objectMapper.writeValueAsString(responseDTO));
    }
}
