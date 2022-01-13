package com.example.demo.repository;

import com.example.demo.model.Translator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long> {
    // Translator findById(String id);
    @Query("SELECT t FROM Translator t WHERE t.variable=?1")
    Translator findByvariable(Long variable);
}
