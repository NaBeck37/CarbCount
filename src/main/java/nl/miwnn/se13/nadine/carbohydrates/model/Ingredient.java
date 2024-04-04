package nl.miwnn.se13.nadine.carbohydrates.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Nadine Beck
 * Foods that are part of a dish and add to its carb count based
 * on their amount of carbohydrates.
 */
@Entity
public class Ingredient {
    @Id @GeneratedValue
    private Long ingredientId;

    private String name;

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
