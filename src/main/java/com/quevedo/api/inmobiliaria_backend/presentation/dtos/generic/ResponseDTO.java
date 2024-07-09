package com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic;

import org.springframework.http.HttpStatus;

public class ResponseDTO<T> {

    private int status;
    private String message;
    private T data;

    // constuctores
    public ResponseDTO(HttpStatus status) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
    }

    public ResponseDTO(HttpStatus status, T data) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
        this.data = data;
    }

    public ResponseDTO(HttpStatus status, String message, T data) {
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    // methods
    public static <T> ResponseDTO<T> of(HttpStatus status) {
        return new ResponseDTO<>(status);
    }

    public static <T> ResponseDTO<T> of(HttpStatus status, T data) {
        return new ResponseDTO<>(status, data);
    }

    public static <T> ResponseDTO<T> of(HttpStatus status, String message, T data) {
        return new ResponseDTO<>(status, message, data);
    }

    // getters and setters

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
