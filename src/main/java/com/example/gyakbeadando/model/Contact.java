package com.example.gyakbeadando.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                // ezt a DB generálja

    @NotBlank(message = "Név kötelező")
    @Column(length = 100)
    private String fullname;

    @NotBlank(message = "E-mail kötelező")
    @Column(length = 100)
    private String email;

    @NotBlank(message = "Telefonszám kötelező")
    @Column(length = 15)
    private String phonenumber;

    @NotBlank(message = "Üzenet kötelező")
    private String message;

    @CreationTimestamp
    private LocalDateTime createdAt;
    ;

    public Contact() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
