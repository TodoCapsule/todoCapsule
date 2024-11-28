package com.example.TodoCapsuleProject.Dday;

import com.example.TodoCapsuleProject.Mate.Mate;
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
    private DdayRepository ddayRepository;

    // D-Day 목록을 보여주는 메서드
    @GetMapping("/alerts")
    public String showDdayAlerts(Model model) {
        List<Dday> ddayList = ddayRepository.findAll();
        log.info("Dday 리스트: {}", ddayList);

        for (Dday dday : ddayList) {
            log.info("제목: {}, 남은 일수: {}", dday.getTitle(), dday.getRemainingDays());
        }

        model.addAttribute("ddayList", ddayList);

        for (Dday dday : ddayList) {
            log.info("남은 일수 (remainingDays): {}", dday.getRemainingDays());
        }
        return "dday/alerts";
    }
}
