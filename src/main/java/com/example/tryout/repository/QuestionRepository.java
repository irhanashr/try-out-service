package com.example.tryout.repository;

import com.example.tryout.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {
    // Mencari semua soal yang ada dalam satu paket soal
    List<Question> findByQuestionBankId(UUID bankId);
}
