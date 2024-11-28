package com.example.TodoCapsuleProject.Dday;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DdayController {
    @Autowired
    private DdayService ddayService;

    // D-Day 목록을 보여주는 메서드
    @GetMapping("/alerts")
    public String showDdayAlerts(Model model) {
        model.addAttribute("ddayList", ddayService.getDdayList());
        return "alerts";
    }
}
