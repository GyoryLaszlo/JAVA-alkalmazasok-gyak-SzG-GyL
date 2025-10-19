package com.example.gyakbeadando.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterForm {

    @NotBlank(message = "Felhasználónév kötelező")
    @Size(min = 3, max = 50, message = "3–50 karakter legyen")
    private String username;

    @NotBlank(message = "Jelszó kötelező")
    @Size(min = 6, max = 100, message = "Legalább 6 karakter")
    private String password;

    @NotBlank(message = "Jelszó megerősítés kötelező")
    private String confirmPassword;

    public RegisterForm() {}

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
