package pl.zini.service;

import org.springframework.stereotype.Service;
import pl.zini.model.*;
import pl.zini.repository.MealRepository;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
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
}
