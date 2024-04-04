package nl.miwnn.se13.nadine.carbohydrates.repositories;

import nl.miwnn.se13.nadine.carbohydrates.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
