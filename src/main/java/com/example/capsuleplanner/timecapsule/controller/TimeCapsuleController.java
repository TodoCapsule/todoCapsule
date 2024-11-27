package com.example.capsuleplanner.timecapsule.controller;

import com.example.capsuleplanner.timecapsule.service.TimeCapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeCapsuleController {

    @Autowired
    private TimeCapsuleService timeCapsuleService;

    @GetMapping("/timecapsules")
    public String listAllTimeCapsules(Model model) {
        model.addAttribute("timeCapsules", timeCapsuleService.getAllCapsules());
        return "/timecapsule/timecapsules";
    }

    @GetMapping("/alerts")
    public String listUpcomingCapsules(Model model) {
        model.addAttribute("upcomingCapsules", timeCapsuleService.getUpcomingCapsules());
        return "/timecapsule/alerts";
    }
}