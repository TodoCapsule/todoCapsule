package com.example.TodoCapsuleProject.Mate;

import com.example.TodoCapsuleProject.Dday.TimeCapsule;
import com.example.TodoCapsuleProject.Dday.TimeCapsuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class PlannerController {

    @Autowired
    PlannerRepository plannerRepository;

    @Autowired
    private TimeCapsuleRepository timeCapsuleRepository;

    //새 항목 추가 Form
    @GetMapping("planner/new")
    public String newPlannerForm() {
        return "planner/new";
    }

    //조회
    @GetMapping("/planner")
    public String list(Model model){
        List<Planner> plannerList = plannerRepository.findAll();
        model.addAttribute("plannerList", plannerList);
        return "planner/index";
    }
    
    //생성
    @PostMapping("/planner/create")
    public String addPlanner(PlannerDto plannerDto){
        plannerDto.logInfo();

        //DTO를 Entity로 변환
        Planner planner = plannerDto.toEntity();
        planner.logInfo();

        //repository로 Entity를 저장
        Planner saved = plannerRepository.save(planner);
        saved.logInfo();

        // 날짜가 설정된 경우 TimeCapsule에 추가
        if (planner.getDate() != null) {
            TimeCapsule timeCapsule = new TimeCapsule(
                    planner.getTitle(),
                    planner.getContent(),
                    planner.getCategory(),
                    planner.getDate(),
                    false
            );
            timeCapsuleRepository.save(timeCapsule);
        }

        return "redirect:/planner/" + saved.getId();
    }

    //단일 데이터 죠회
    @GetMapping("/planner/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        log.info("id = {}", id);

        //id를 조회하여 planner 데이터 가져오기
        //Optional<Planner> planner = plannerRepository.findById(id);
        Planner planner = plannerRepository.findById(id).orElse(null);

        //모델에 등록
        model.addAttribute("planner", planner);

        //뷰 페이지 반환
        return "planner/show";
    }

    //데이터 수정을 위해 원본 데이터 가져오기
    @GetMapping("/planner/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Planner planner = plannerRepository.findById(id).orElse(null);
        model.addAttribute("planner", planner);

        return "planner/edit";
    }
    //수정
    @PostMapping("/planner/update")
    public String update(PlannerDto plannerDto){
        log.info(plannerDto.toString()); //DTO 확인

        //DTO -> Entity
        Planner planner = plannerDto.toEntity();
        log.info(planner.toString()); //entity 변환 확인

        Planner target = plannerRepository.findById(planner.getId()).orElse(null);
        if(target != null){
            plannerRepository.save(planner);
        }
        //redirect
        return "redirect:/planner/" + target.getId();
    }

    //삭제
    @GetMapping("/planner/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes rttr){
        Planner target = plannerRepository.findById(id).orElse(null);
        if(target != null){
            plannerRepository.deleteById(id);
            //삭제 완료 메시지
            rttr.addFlashAttribute("msg", ".");
        }
        //index 페이지로 redirec
        return "redirect:/planner";
    }
}
