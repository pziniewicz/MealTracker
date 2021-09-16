package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zini.model.Meal;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

//    List<Meal> getAllByDateAndPlanIsActiveAndUser(LocalDate date, Integer isActive, User user);

    Meal getByDateAndPlanAndMealName(LocalDate date, Plan plan, MealName mealName);


}
