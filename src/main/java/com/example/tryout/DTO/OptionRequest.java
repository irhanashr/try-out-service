package com.example.tryout.DTO;

import lombok.Data;

@Data
public class OptionRequest {
    private String label;
    private String content;
    private boolean isCorrect;
}
