package pl.zini.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zini.model.*;
import pl.zini.repository.MealRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MealService {

    private final MealRepository mealRepository;
    private final PlanService planService;

    public MealService(MealRepository mealRepository, PlanService planService) {
        this.mealRepository = mealRepository;
        this.planService = planService;
    }

    public Meal getById(Long id) {
        return mealRepository.getById(id);
    }

    public Meal getByDateAndPlanAndMealName(LocalDate date, Plan plan, MealName mealName) {
        return mealRepository.getByDateAndPlanAndMealName(date, plan, mealName);
    }

    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    public List<Meal> getByDateAndPlan(LocalDate date, Long id) {
        return mealRepository.getByDateAndPlan(date, id);
    }

    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    public void deleteMealsByMealNameAndPlan(Long mealNameId, Long planId) {
        mealRepository.deleteMealsByMealNameAndPlan(mealNameId, planId);
    }

    @Transactional
    public void createMeals(String date, Plan activePlan) {
        List<MealName> mealNames = activePlan.getMealNames();
        for (MealName mealName : mealNames) {
            if (getByDateAndPlanAndMealName(LocalDate.parse(date), activePlan, mealName) == null) {
                Meal meal = new Meal();
                meal.setDate(LocalDate.parse(date));
                meal.setPlan(activePlan);
                meal.setMealName(mealName);
                save(meal);
            }
        }
    }

    public Map<String, Integer> getCaloryAndMakrosData(String date, User user) {
        Map<String, Integer> data = new HashMap<>();
        Plan activePlan = planService.getByUserAndIsActive(user, 1);
        data.put("calDemand", activePlan.getCaloricDemand());
        data.put("proteinDemand", activePlan.getProteinQuantity());
        data.put("carbsDemand", activePlan.getCarbsQuantity());
        data.put("fatDemand", activePlan.getFatQuantity());
        List<Meal> meals = getByDateAndPlan(LocalDate.parse(date), activePlan.getId());
        Integer calories = 0;
        Integer protein = 0;
        Integer carbs = 0;
        Integer fat = 0;
        for (Meal meal : meals) {
            for (Ingredient ingredient : meal.getIngredients()) {
                calories += ingredient.getCalories()
                        .intValue();
                protein += ingredient.getProtein()
                        .intValue();
                carbs += ingredient.getCarbs()
                        .intValue();
                fat += ingredient.getFat()
                        .intValue();
            }
        }
        Integer caloriesPercent = (calories * 10 / activePlan.getCaloricDemand()) * 10;
        Integer proteinPercent = (protein * 10 / activePlan.getProteinQuantity()) * 10;
        Integer carbsPercent = (carbs * 10 / activePlan.getCarbsQuantity()) * 10;
        Integer fatPercent = (fat * 10 / activePlan.getFatQuantity()) * 10;
        data.put("calories", calories);
        data.put("protein", protein);
        data.put("carbs", carbs);
        data.put("fat", fat);
        data.put("caloriesPercent", caloriesPercent);
        data.put("proteinPercent", proteinPercent);
        data.put("carbsPercent", carbsPercent);
        data.put("fatPercent", fatPercent);
        return data;
    }
}
