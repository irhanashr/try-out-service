package com.example.tryout.repository;

import com.example.tryout.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OptionRepository extends JpaRepository<Option, UUID> {
    // Mencari semua pilihan jawaban berdasarkan ID soal
    List<Option> findByQuestionId(UUID questionId);
}
