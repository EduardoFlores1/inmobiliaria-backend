package com.quevedo.api.inmobiliaria_backend.presentation.dtos.login;

public class LoginResponseDTO {
    private String type;
    private String token;

    // constructor

    public LoginResponseDTO(String type, String token) {
        this.type = type;
        this.token = token;
    }

    // getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
