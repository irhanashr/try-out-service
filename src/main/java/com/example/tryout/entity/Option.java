package com.example.tryout.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "options")
@Getter
@Setter
public class Option extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    private String label; // A, B, C...

    @Column(columnDefinition = "text")
    private String content;

    private boolean isCorrect = false;
}
