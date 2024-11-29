package com.example.TodoCapsuleProject.Dday;

import com.example.TodoCapsuleProject.Mate.Mate;
import com.example.TodoCapsuleProject.Mate.MateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class DdayController {
    @Autowired
    private DdayService ddayService;

    @Autowired
    private MateRepository mateRepository;

    // D-Day 목록을 보여주는 메서드
    @GetMapping("/alerts")
    public String showDdayAlerts(Model model) {
        List<Mate> mateList = mateRepository.findAll();
        log.info("Dday 리스트: {}", mateList);

        for (Mate mate : mateList) {
            log.info("제목: {}, 남은 일수: {}", mate.getTitle(),mate.getRemainingDays());
        }

        model.addAttribute("mateList", mateList);

        for (Mate mate : mateList) {
            log.info("남은 일수 (remainingDays): {}", mate.getRemainingDays());
        }
        return "dday/alerts";
    }
}
