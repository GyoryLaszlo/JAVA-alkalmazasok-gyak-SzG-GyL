package com.example.gyakbeadando.repo;

import com.example.gyakbeadando.model.Gep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface GepRepository extends JpaRepository<Gep, Long> {

    // EGYBEN listázás a kapcsolt processzor + oprendszer mezőkkel
    @Query("""
           select g
           from Gep g
           join fetch g.processzor
           join fetch g.oprendszer
           """)
    List<Gep> findAllWithRefs();
}
