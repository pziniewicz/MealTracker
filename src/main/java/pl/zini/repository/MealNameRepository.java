package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zini.model.MealName;
import pl.zini.model.Plan;

import java.util.List;

@Repository
public interface MealNameRepository extends JpaRepository<MealName, Long> {
    @Override
    List<MealName> findAll();

    List<MealName> getByPlans(Plan plan);

}
