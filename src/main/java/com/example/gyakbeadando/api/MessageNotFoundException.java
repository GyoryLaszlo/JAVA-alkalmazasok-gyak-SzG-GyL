package com.example.gyakbeadando.api;

public class MessageNotFoundException extends RuntimeException {
    MessageNotFoundException(Integer id){
        super("Az üzenet nem található: " + id);
    }
}
