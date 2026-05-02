package com.example.tryout.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SubjectMenuResponse {
    private UUID id;
    private String name;
    private List<QuestionBankSummary> subSubjects;

    @Data
    @AllArgsConstructor
    public static class QuestionBankSummary {
        private UUID id;
        private String title;
    }
}
