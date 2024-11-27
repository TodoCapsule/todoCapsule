package com.example.capsuleplanner.planner.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Planner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String category;
    private Boolean isCompleted = false;
    private LocalDate date;

    public void logInfo(){
        log.info("id: {}, title: {}, content: {}, category: {}, isCompleted: {}", id, title, content, category, isCompleted);
    }
}
