package com.example.TodoCapsuleProject.TimeCapsule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @ToString @Slf4j
public class TimeCapsule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;               // 제목
    private String content;             // 할일 내용
    private String category;            // 카테고리
    private LocalDate alertDate;        // 알림 날짜
    private boolean isOpened = false;   // 타임캡슐 열림 여부

    public TimeCapsule(String title, String content, String category, LocalDate alertDate, boolean isOpened) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.alertDate = alertDate;
        this.isOpened = isOpened;
    }

    public void logInfo() {
        log.info("TimeCapsule Created - ID: {}, Title: {}, Category: {}, AlertDate: {}, IsOpened: {}", id, title, category, alertDate, isOpened);
    }
}
