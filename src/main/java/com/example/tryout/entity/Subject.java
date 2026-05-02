package com.example.tryout.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject extends BaseEntity {
    private String name;
    private boolean isActive = true;
}
