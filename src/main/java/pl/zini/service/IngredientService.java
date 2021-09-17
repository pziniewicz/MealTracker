package pl.zini.service;

import org.springframework.stereotype.Service;
import pl.zini.model.Ingredient;
import pl.zini.repository.IngredientRepository;

@Service
public class IngredientService {

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    private final IngredientRepository ingredientRepository;

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

}
