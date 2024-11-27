package com.example.capsuleplanner.timecapsule.service.Impl;

import com.example.capsuleplanner.timecapsule.entity.TimeCapsule;
import com.example.capsuleplanner.timecapsule.repository.TimeCapsuleRepository;
import com.example.capsuleplanner.timecapsule.service.TimeCapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TimeCapsuleServiceImpl implements TimeCapsuleService {

    @Autowired
    private TimeCapsuleRepository timeCapsuleRepository;

    @Override
    public List<TimeCapsule> getAllCapsules() {
        return timeCapsuleRepository.findAll();
    }

    @Override
    public List<TimeCapsule> getUpcomingCapsules() {
        LocalDate today = LocalDate.now();

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

        // 해당 알림 날짜로 타임캡슐 검색
        return timeCapsuleRepository.findByAlertDate(alertDate);
    }
}
