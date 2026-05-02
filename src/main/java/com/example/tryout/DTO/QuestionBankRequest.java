package com.example.tryout.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class QuestionBankRequest {
    // ID Subject untuk menghubungkan paket soal ini ke mata pelajaran tertentu
    private UUID subjectId;

    // Judul paket soal, misal: "Latihan UTS Semester 1"
    private String title;

    // Opsional: Jika kamu ingin menyimpan durasi atau passing grade
    private Integer duration; // dalam menit
    private Integer passingGrade;
}
