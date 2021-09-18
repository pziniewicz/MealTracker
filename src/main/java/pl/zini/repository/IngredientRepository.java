package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zini.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


}
