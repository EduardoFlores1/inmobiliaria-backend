package com.quevedo.api.inmobiliaria_backend.presentation.exceptions;

import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ErrorDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // entidad no encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> HandleNotFoundException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.of(HttpStatus.NOT_FOUND, ErrorDTO.of(1, "Entidad no Encontrada")));
    }

    // argumentos inválidos en el request, validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ResponseDTO<List<ValidationFieldError>>> handleBadRequestException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ResponseDTO.of(HttpStatus.BAD_REQUEST, errors.stream().map(ValidationFieldError::new).toList()));
    }

    // estructura del request incompatible por la definida en la api
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> handleBadRequestException(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ResponseDTO.of(HttpStatus.BAD_REQUEST, ErrorDTO.of(1, ex.getMessage())));
    }

    // Esta excepción se lanza cuando la autenticación falla debido a credenciales inválidas, ex username or password
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> handleBadCredentialsException() {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseDTO.of(HttpStatus.UNAUTHORIZED, ErrorDTO.of(1, "Credenciales inválidas")));
    }

    // padre de BadCredentialsExceptions, abarca mas excepciones de autenticacion de spring security
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseDTO.of(HttpStatus.UNAUTHORIZED, ErrorDTO.of(1, "Autenticación fallida: ".concat(ex.getMessage()))));
    }

    // se lanza cuando se deniega el acceso a un recurso protegido a un usuario autenticado
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ResponseDTO.of(HttpStatus.FORBIDDEN, ErrorDTO.of(1, "Acceso denegado: ".concat(ex.getMessage()))));
    }

    /*
        se lanza cuando ocurre una violación de integridad de datos en una base de datos
        Esta excepción se utiliza para indicar que una operación de base de datos ha fallado
        debido a una violación de las restricciones de integridad de los datos, como las restricciones
        de clave primaria, clave externa, unicidad, o cualquier otra restricción definida en la base de datos
    */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ResponseDTO.of(HttpStatus.CONFLICT, ErrorDTO.of(1, "Error: ".concat(String.valueOf(ex.getMostSpecificCause())))));
    }

    // la madre de todas
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ErrorDTO>> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDTO.of(HttpStatus.INTERNAL_SERVER_ERROR, ErrorDTO.of(1, "Error: ".concat(ex.getLocalizedMessage()))));
    }

    private record ValidationFieldError(String field, String message) {
        public ValidationFieldError(FieldError err) {
            this(err.getField(), err.getDefaultMessage());
        }
    }
}
