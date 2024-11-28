package com.example.TodoCapsuleProject.Dday;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TimeCapsuleController {

    @Autowired
    private TimeCapsuleService timeCapsuleService;

    @GetMapping("/")
    public String index(Model model) {
        log.info("Displaying the index page...");
        // 필요한 데이터를 모델에 추가할 수 있습니다
        model.addAttribute("message", "마감 기한이 존재하는 할일을 타임캡슐에서 관리하세요!");
        return "timecapsule/index";  // timecapsule/index.mustache 템플릿을 반환
    }

    @GetMapping("/timecapsules")
    public String listAllTimeCapsules(Model model) {
        log.info("Fetching all time capsules...");
        model.addAttribute("timeCapsules", timeCapsuleService.getAllCapsules());
        return "timecapsule/timecapsulesList";
    }

    @GetMapping("/alerts")
    public String listUpcomingCapsules(Model model) {
        log.info("Fetching upcoming time capsules for alerts...");
        model.addAttribute("upcomingCapsules", timeCapsuleService.getUpcomingCapsules());
        return "timecapsule/alerts";
    }
}