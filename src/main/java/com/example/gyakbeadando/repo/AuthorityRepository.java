package com.example.gyakbeadando.repo;

import com.example.gyakbeadando.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    void deleteByUsername(String username);
}
