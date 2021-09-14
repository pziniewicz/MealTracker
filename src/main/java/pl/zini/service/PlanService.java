package pl.zini.service;

import org.springframework.stereotype.Service;
import pl.zini.model.Plan;
import pl.zini.repository.PlanRepository;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan getById(Long id) {
        return planRepository.getById(id);
    }

    public void save(Plan plan) {
        plan.setCaloricDemandAndMacros();
        planRepository.save(plan);
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public void delete(Plan article) {
        planRepository.delete(article);
    }
}
