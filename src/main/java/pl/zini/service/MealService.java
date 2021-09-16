package pl.zini.service;

import org.springframework.stereotype.Service;
import pl.zini.model.Meal;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;
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

//    public List<Meal> getMealsForDay(LocalDate date, Integer isActive, User user) {
//        return mealRepository.getAllByDateAndPlanIsActiveAndUser(date,isActive,user);
//    }

    public Meal getByDateAndPlanAndMealName(LocalDate date, Plan plan, MealName mealName) {
        return mealRepository.getByDateAndPlanAndMealName(date, plan, mealName);
    }

    public void save(Meal meal) {
        mealRepository.save(meal);
    }

}
