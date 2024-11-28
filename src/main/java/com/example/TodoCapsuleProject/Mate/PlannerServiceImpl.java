package com.example.TodoCapsuleProject.Mate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannerServiceImpl implements PlannerService {
    private PlannerRepository plannerRepository;

    @Autowired
    public PlannerServiceImpl(PlannerRepository plannerRepository){
        this.plannerRepository = plannerRepository;
    }

    //모든 Todo 항목 가져오기
    @Override
    public List<Planner> getPlannerList() {
        List<Planner> planners = plannerRepository.findAll();
        return planners;
    }

    //특정 Todo 항목 가져오기
    public Planner getPlanner(Long id){
        return plannerRepository.findById(id).orElse(null);
    }
}
