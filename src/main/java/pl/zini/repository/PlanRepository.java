package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findByUserId(Long id);
    Plan getById(Long id);
    Plan getByUserAndIsActive(User user, Integer isActive);
}
