package com.example.TodoCapsuleProject.Dday;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter @Setter @NoArgsConstructor @ToString @Slf4j
public class Dday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;           // 제목
    private String content;         // 할일 내용
    private String category;        // 카테고리
    private LocalDate date;         // Mate에서 받아온 날짜(기한)
    private long remainingDays;    // 남은 일수


    public Dday(String title, String content, String category, LocalDate date, long remainingDays) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
        this.remainingDays = remainingDays;
    }

    public void logInfo() {
        log.info("D-Day Setting - ID: {}, Title: {}, Category: {}, Date: {} D-day: {}", id, title, category, date, remainingDays);
    }

    // 현재 날짜와 D-Day 날짜 차이 계산
    public int getRemainingDays() {
        if (date == null) {
            return -1; // 날짜가 설정되지 않은 경우 -1 반환
        }
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), date);
    }
}
