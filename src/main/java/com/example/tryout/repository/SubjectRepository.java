package com.example.tryout.repository;

import com.example.tryout.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    // Digunakan untuk validasi atau pencarian mata pelajaran
}