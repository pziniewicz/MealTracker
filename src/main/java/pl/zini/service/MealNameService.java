package pl.zini.service;

import org.springframework.stereotype.Service;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;
import pl.zini.repository.MealNameRepository;
import pl.zini.repository.PlanRepository;

import java.util.List;

@Service
public class MealNameService  {

    private final MealNameRepository mealNameRepository;
    private final PlanRepository planRepository;
    private final UserServiceImpl userService;

    public MealNameService(MealNameRepository mealNameRepository, PlanRepository planRepository, UserServiceImpl userService) {
        this.mealNameRepository = mealNameRepository;
        this.planRepository = planRepository;
        this.userService = userService;
    }

    public List<MealName> findAll() {
        return mealNameRepository.findAll();
    }

    public List<MealName> getByPlan(Plan plan) {
        return mealNameRepository.getByPlans(plan);
    }

}
