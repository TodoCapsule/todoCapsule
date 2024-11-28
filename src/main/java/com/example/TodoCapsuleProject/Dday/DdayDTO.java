package com.example.TodoCapsuleProject.Dday;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Slf4j
public class DdayDTO {
    private String title;          // 제목
    private String content;        // 내용
    private String category;       // 카테고리
    private LocalDate date;        // 기한 날짜
    private long remainingDays;    // 남은 일수
}