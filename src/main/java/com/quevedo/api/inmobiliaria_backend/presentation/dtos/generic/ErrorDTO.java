package com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic;

public class ErrorDTO {
    private int errorCode;
    private String reason;

    // method
    public static ErrorDTO of(int errorCode, String reason) {
        return new ErrorDTO(errorCode, reason);
    }

    // constructor
    public ErrorDTO() {}

    public ErrorDTO(int errorCode, String reason) {
        this.errorCode = errorCode;
        this.reason = reason;
    }

    // getters and setters

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
