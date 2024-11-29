package com.example.TodoCapsuleProject.Mate;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Mate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String category;
    private LocalDate date;

    public void logInfo(){
        log.info("id: {}, title: {}, content: {}, category: {}", id, title, content, category);
    }

    // 남은 일수 계산 메서드
    public int getRemainingDays() {
        if (date == null) {
            return -1; // 날짜가 설정되지 않은 경우 -1 반환
        }
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), date);
    }
}

