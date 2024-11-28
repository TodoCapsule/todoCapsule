package com.example.TodoCapsuleProject.Planner;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Slf4j @ToString
public class PlannerDto {
    private Long id;
    private String title;
    private String content;
    private String category;
    private Boolean isCompleted = false;
    private LocalDate date;

    public Planner toEntity() {
        return new Planner(id, title, content, category, isCompleted, date);
    }

    public void logInfo() {
        log.info("title: {}, content: {} category: {}", title, content, category );
    }
}
