package com.quevedo.api.inmobiliaria_backend.presentation.dtos.login;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    // constructor

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
