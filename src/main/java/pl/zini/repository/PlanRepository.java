package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zini.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findByUserId(Long id);
}
