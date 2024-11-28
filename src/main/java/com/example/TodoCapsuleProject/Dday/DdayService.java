package com.example.TodoCapsuleProject.Dday;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DdayService {
    // Mate에서 등록한 할일을 Dday에 추가하는 메서드
    void addDdayFromMate(String title, String content, String category, LocalDate date);

    // Dday 목록 반환
    List<DdayDTO> getDdayList();
}
