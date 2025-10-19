package com.example.gyakbeadando.repo;

import com.example.gyakbeadando.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Messages, Long> {}
