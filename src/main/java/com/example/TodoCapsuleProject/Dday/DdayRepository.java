package com.example.TodoCapsuleProject.Dday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DdayRepository extends JpaRepository<Dday, Long> {
    // findAll() 등 기본 메서드가 이미 구현되어 있으므로 별도의 추가 코드는 필요 없음
}
