package com.example.gyakbeadando.model;

import jakarta.persistence.*;

@Entity
public class Processzor {
    @Id                     // ID a processzor.txt-ből jön, NEM generált
    private Long id;

    @Column(nullable = false)
    private String gyarto;

    @Column(nullable = false)
    private String tipus;

    public Processzor() {}
    public Processzor(Long id, String gyarto, String tipus) {
        this.id = id; this.gyarto = gyarto; this.tipus = tipus;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getGyarto() { return gyarto; }
    public void setGyarto(String gyarto) { this.gyarto = gyarto; }
    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }
}
