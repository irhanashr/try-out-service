package com.example.tryout.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class QuestionRequest {
    private UUID bankId;
    private String content;
    private String mediaUrl;
    private List<OptionRequest> options;
}
