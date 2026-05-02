package com.example.tryout.controller;

import com.example.tryout.DTO.SubjectMenuResponse;
import com.example.tryout.entity.QuestionBank;
import com.example.tryout.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class PublicController {
    private final QuestionService questionService;

    @GetMapping("/subjects/menu")
    public ResponseEntity<List<SubjectMenuResponse>> getSidebarMenu() {
        return ResponseEntity.ok(questionService.getAllSubjectsForMenu());
    }
}
