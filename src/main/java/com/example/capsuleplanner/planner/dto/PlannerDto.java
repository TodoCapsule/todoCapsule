package com.example.capsuleplanner.planner.dto;

import com.example.capsuleplanner.planner.entity.Planner;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString
public class PlannerDto {
    private Long id;
    private String title;
    private String content;
    private String category;
    private Boolean isCompleted = false;

    public Planner toEntity() {
        return new Planner(id, title, content, category, isCompleted);
    }

    public void logInfo() {
        log.info("title: {}, content: {} category: {}", title, content, category );
    }
}
