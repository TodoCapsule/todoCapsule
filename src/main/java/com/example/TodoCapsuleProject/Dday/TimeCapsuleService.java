package com.example.TodoCapsuleProject.Dday;

import java.util.List;

public interface TimeCapsuleService {
    // 모든 타임캡슐 목록을 반환하는 메서드
    List<TimeCapsule> getAllCapsules();

    // 알림을 3일 전에 제공하는 메서드
    List<TimeCapsule> getUpcomingCapsules();
}
