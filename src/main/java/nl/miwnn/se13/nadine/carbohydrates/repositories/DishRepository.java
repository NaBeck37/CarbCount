package nl.miwnn.se13.nadine.carbohydrates.repositories;

import nl.miwnn.se13.nadine.carbohydrates.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository <Dish, Long> {
}
