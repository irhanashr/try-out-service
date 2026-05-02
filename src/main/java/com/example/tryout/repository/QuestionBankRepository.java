package com.example.tryout.repository;

import com.example.tryout.entity.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, UUID> {
    // Mencari semua paket soal berdasarkan mata pelajaran tertentu jika diperlukan
    List<QuestionBank> findBySubjectId(UUID subjectId);
}
