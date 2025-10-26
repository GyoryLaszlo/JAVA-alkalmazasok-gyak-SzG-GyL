package com.example.gyakbeadando.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(length = 50)
    private String username;

    @Column(length = 50)
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return switch (authority) {
            case "ROLE_ADMIN" -> "Adminisztrátor";
            case "ROLE_USER" -> "Regisztrált látogató";
            default -> authority;
        };
    }
}
