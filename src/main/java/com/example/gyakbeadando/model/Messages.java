package com.example.gyakbeadando.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                // ezt a DB generálja

    @Column(length = 100)
    private String fullname;
    @Column(length = 100)
    private String email;
    @Digits(integer = 11, fraction = 0)
    private Integer phonenumber;
    private String message;

    protected Messages() {
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

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
