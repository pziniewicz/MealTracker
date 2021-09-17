package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.zini.model.*;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {


    Meal getByDateAndPlanAndMealName(LocalDate date, Plan plan, MealName mealName);

    Meal getById(Long id);

    @Query(value = "SELECT * FROM meals where date = :date and plan_id = :id order by mealName_id", nativeQuery = true)
    List<Meal> getByDateAndPlan(LocalDate date, Long id);

    @Query(value = "DELETE FROM meals where mealName_id = :mealNameId and plan_id = :planId ", nativeQuery = true)
    void deleteMealsByMealNameAndPlan(Long mealNameId, Long planId);

}
