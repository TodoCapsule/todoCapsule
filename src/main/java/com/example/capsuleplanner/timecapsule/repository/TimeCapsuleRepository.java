package com.example.capsuleplanner.timecapsule.repository;

import com.example.capsuleplanner.timecapsule.entity.TimeCapsule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeCapsuleRepository extends JpaRepository<TimeCapsule, Long> {
    // 알림 날짜통해서 타임캡슐로 알리는 할일인지 검색
    List<TimeCapsule> findByAlertDate(LocalDate alertDate);
}