package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zini.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
