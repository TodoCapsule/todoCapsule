package com.example.TodoCapsuleProject.Mate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}
