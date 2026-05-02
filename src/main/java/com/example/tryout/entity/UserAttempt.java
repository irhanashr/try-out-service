package com.example.tryout.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "user_attempts")
@Getter
@Setter
public class UserAttempt extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private QuestionBank questionBank;

    private Instant startTime;
    private Instant endTime;

    @Column(precision = 5, scale = 2)
    private BigDecimal score;
}
