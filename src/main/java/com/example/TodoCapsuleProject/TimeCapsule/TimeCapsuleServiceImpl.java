package com.example.TodoCapsuleProject.TimeCapsule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class TimeCapsuleServiceImpl implements TimeCapsuleService {

    @Autowired
    private TimeCapsuleRepository timeCapsuleRepository;

    @Override
    public List<TimeCapsule> getAllCapsules() {
        log.info("Fetching all time capsules...");
        return timeCapsuleRepository.findAll();
    }

    @Override
    public List<TimeCapsule> getUpcomingCapsules() {
        LocalDate today = LocalDate.now();
        log.info("Calculating upcoming time capsules for alerting... Current date: {}", today);

        // 날짜를 계산하며 월말 문제 처리
        int day = today.getDayOfMonth() + 3; // 3일 추가
        int month = today.getMonthValue();
        int year = today.getYear();

        // 해당 월의 마지막 날 계산
        int lastDayOfMonth = today.lengthOfMonth();
        if (day > lastDayOfMonth) {
            day -= lastDayOfMonth; // 초과된 일수만큼 다음 달로 이동
            month++;
            if (month > 12) { // 12월 초과 시 연도 변경
                month = 1;
                year++;
            }
        }

        // 최종적으로 알림 날짜를 계산
        LocalDate alertDate = LocalDate.of(year, month, day);
        log.info("Calculated alert date: {}", alertDate);

        // 해당 알림 날짜로 타임캡슐 검색
        return timeCapsuleRepository.findByAlertDate(alertDate);
    }
}
