package com.example.gyakbeadando.repo;

import com.example.gyakbeadando.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}
