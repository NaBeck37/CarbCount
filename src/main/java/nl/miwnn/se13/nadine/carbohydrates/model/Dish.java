package nl.miwnn.se13.nadine.carbohydrates.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * Nadine Beck
 * Represents a dish that can be eaten in a day.
 */

@Entity
public class Dish {
    @Id @GeneratedValue
    private Long dishId;
    private String name;
    private String ingredient;
    private int gramsOfCarbohydrates;

    @OneToMany(mappedBy = "dish")
    private List<Meal> meals;

    public int getNumberOfTimesEaten() {
        return meals.size();
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getGramsOfCarbohydrates() {
        return gramsOfCarbohydrates;
    }

    public void setGramsOfCarbohydrates(int gramsOfCarbohydrates) {
        this.gramsOfCarbohydrates = gramsOfCarbohydrates;
    }
}
