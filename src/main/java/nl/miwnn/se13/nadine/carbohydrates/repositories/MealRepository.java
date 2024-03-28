package nl.miwnn.se13.nadine.carbohydrates.repositories;

import nl.miwnn.se13.nadine.carbohydrates.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

}
