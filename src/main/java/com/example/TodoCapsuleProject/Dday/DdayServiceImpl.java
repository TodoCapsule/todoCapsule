package com.example.TodoCapsuleProject.Dday;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DdayServiceImpl implements DdayService{
    @Autowired
    private DdayRepository ddayRepository;

    // Mate에서 할일을 Dday로 추가
    @Override
    public void addDdayFromMate(String title, String content, String category, LocalDate date, Long remainingDays) {
        Dday dday = new Dday(title, content, category, date, remainingDays);
        ddayRepository.save(dday);  // Dday 테이블에 저장
    }

    // D-Day 목록 반환
    @Override
    public List<DdayDTO> getDdayList() {
        return ddayRepository.findAll().stream().map(dday -> {
            // Dday 엔티티에서 직접 LocalDate 사용하여 남은 일수 계산
            long remainingDays = dday.getRemainingDays();  // D-Day 남은 일수

            return new DdayDTO(
                    dday.getId(),
                    dday.getTitle(),
                    dday.getContent(),
                    dday.getCategory(),
                    dday.getDate(),     // 저장된 날짜 그대로 반환
                    remainingDays       // D-Day 남은 일수
            );
        }).collect(Collectors.toList());
    }
}
