package pl.zini.service;

import org.springframework.stereotype.Service;
import pl.zini.model.Ingredient;
import pl.zini.repository.IngredientRepository;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void edit(Long ingredientId, Integer quantity) {
        ingredientRepository.getById(ingredientId)
                .setQuantity(quantity);
    }

    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }

    public Ingredient getById(Long id) {
        return ingredientRepository.getById(id);
    }
}
