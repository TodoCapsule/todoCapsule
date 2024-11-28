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

@Entity
@Getter @Setter @NoArgsConstructor @ToString @Slf4j
public class Dday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;           // 제목
    private String content;         // 할일 내용
    private String category;        // 카테고리
    private String date;            // Mate에서 받아온 날짜(기한)

    public Dday(String title, String content, String category, String date) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
    }

    public void logInfo() {
        log.info("D-Day Setting - ID: {}, Title: {}, Category: {}, Date: {}", id, title, category, date);
    }
}
