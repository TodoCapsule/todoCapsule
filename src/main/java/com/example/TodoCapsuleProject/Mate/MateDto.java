package com.example.TodoCapsuleProject.Mate;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Slf4j @ToString
public class MateDto {
    private Long id;
    private String title;
    private String content;
    private String category;
    private LocalDate date;

    public Mate toEntity() {
        return new Mate(id, title, content, category, date);
    }

    public void logInfo() {
        log.info("title: {}, content: {}, category: {}, date: {}", title, content, category, date);
    }
}
