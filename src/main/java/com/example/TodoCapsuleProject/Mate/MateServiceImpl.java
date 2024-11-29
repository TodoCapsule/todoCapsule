package com.example.TodoCapsuleProject.Mate;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MateServiceImpl implements MateService {
    private MateRepository mateRepository;

    @Autowired
    public MateServiceImpl(MateRepository mateRepository){
        this.mateRepository = mateRepository;
    }

    //모든 Todo 항목 가져오기
    @Override
    public List<Mate> getMateList() {
        List<Mate> mates = mateRepository.findAll();
        return mates;
    }

    //특정 Todo 항목 가져오기
    public Mate getMate(Long id){
        return mateRepository.findById(id).orElse(null);
    }
    public void updateMate(MateDto mateDto) {
        Mate existingMate = mateRepository.findById(mateDto.getId()).orElse(null);
        if (existingMate != null) {
            existingMate.setTitle(mateDto.getTitle());
            existingMate.setContent(mateDto.getContent());
            existingMate.setCategory(mateDto.getCategory());
            existingMate.setDate(mateDto.getDate());
            mateRepository.save(existingMate);
        }
    }

    public void deleteMate(Long id) {
        if (mateRepository.existsById(id)) {
            mateRepository.deleteById(id);
        }
    }
}