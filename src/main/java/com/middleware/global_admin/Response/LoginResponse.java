package com.middleware.global_admin.Response;

public class LoginResponse {

    private String message;
    private Boolean status;
    private String token;
    private String role;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LoginResponse(String message, Boolean status, String token) {
        this.message = message;
        this.status = status;
        this.token = token;
    }

    public LoginResponse(String message, Boolean status, String token, String role) {
        this.message = message;
        this.status = status;
        this.token = token;
        this.role = role;
    }
}
