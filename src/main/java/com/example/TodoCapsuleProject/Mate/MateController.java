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
public class MateController {

    @Autowired
    MateRepository mateRepository;

    @Autowired
    private TimeCapsuleRepository timeCapsuleRepository;

    //새 항목 추가 Form
    @GetMapping("mate/new")
    public String newMateForm() {
        return "mate/new";
    }

    //조회
    @GetMapping("/mate")
    public String list(Model model){
        List<Mate> mateList = mateRepository.findAll();
        model.addAttribute("mateList", mateList);
        return "mate/index";
    }

    //생성
    @PostMapping("/mate/create")
    public String addMate(MateDto mateDto){
        mateDto.logInfo();

        //DTO를 Entity로 변환
        Mate mate = mateDto.toEntity();
        mate.logInfo();

        //repository로 Entity를 저장
        Mate saved = mateRepository.save(mate);
        saved.logInfo();

        // 날짜가 설정된 경우 TimeCapsule에 추가
        if (mate.getDate() != null) {
            TimeCapsule timeCapsule = new TimeCapsule(
                    mate.getTitle(),
                    mate.getContent(),
                    mate.getCategory(),
                    mate.getDate(),
                    false
            );
            timeCapsuleRepository.save(timeCapsule);
        }

        return "redirect:/mate/" + saved.getId();
    }

    //단일 데이터 죠회
    @GetMapping("/mate/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        log.info("id = {}", id);

        //id를 조회하여 mate 데이터 가져오기
        //Optional<Mate> mate = mateRepository.findById(id);
        Mate mate = mateRepository.findById(id).orElse(null);

        //모델에 등록
        model.addAttribute("mate", mate);

        //뷰 페이지 반환
        return "mate/show";
    }

    //데이터 수정을 위해 원본 데이터 가져오기
    @GetMapping("/mate/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Mate mate = mateRepository.findById(id).orElse(null);
        model.addAttribute("mate", mate);

        return "mate/edit";
    }
    //수정
    @PostMapping("/mate/update")
    public String update(MateDto mateDto){
        log.info(mateDto.toString()); //DTO 확인

        //DTO -> Entity
        Mate mate = mateDto.toEntity();
        log.info(mate.toString()); //entity 변환 확인

        Mate target = mateRepository.findById(mate.getId()).orElse(null);
        if(target != null){
            mateRepository.save(mate);
        }
        //redirect
        return "redirect:/mate/" + target.getId();
    }

    //삭제
    @GetMapping("/mate/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes rttr){
        Mate target = mateRepository.findById(id).orElse(null);
        if(target != null){
            mateRepository.deleteById(id);
            //삭제 완료 메시지
            rttr.addFlashAttribute("msg", ".");
        }
        //index 페이지로 redirect
        return "redirect:/mate";
    }
}
