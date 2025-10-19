package com.example.gyakbeadando.model;

import jakarta.persistence.*;

@Entity
public class Oprendszer {
    @Id                     // ID az oprendszer.txt-ből jön, NEM generált
    private Long id;

    @Column(nullable = false, unique = true)
    private String nev;

    public Oprendszer() {}
    public Oprendszer(Long id, String nev) { this.id = id; this.nev = nev; }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }
}
