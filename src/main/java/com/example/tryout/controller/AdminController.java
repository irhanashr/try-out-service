package com.example.tryout.controller;

import com.example.tryout.DTO.QuestionBankRequest;
import com.example.tryout.DTO.QuestionRequest;
import com.example.tryout.entity.QuestionBank;
import com.example.tryout.entity.Subject;
import com.example.tryout.repository.QuestionBankRepository;
import com.example.tryout.repository.SubjectRepository;
import com.example.tryout.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final QuestionService questionService;
    private final QuestionBankRepository bankRepository;
    private  final SubjectRepository subjectRepository;

    @PostMapping("/questions")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(questionService.createQuestion(request));
    }

    @GetMapping("/question-banks")
    public ResponseEntity<?> getAllBanks() {
        return ResponseEntity.ok(bankRepository.findAll());
    }

    @PostMapping("/question-banks")
    public ResponseEntity<?> addBank(@RequestBody QuestionBankRequest request) {
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        QuestionBank bank = new QuestionBank();
        bank.setSubject(subject);
        bank.setTitle(request.getTitle());
        bank.setPublished(true);
        // ... set config lainnya
        return ResponseEntity.ok(bankRepository.save(bank));
    }

    @PostMapping("/subjects")
    public ResponseEntity<?> addSubject(@RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectRepository.save(subject));
    }
}