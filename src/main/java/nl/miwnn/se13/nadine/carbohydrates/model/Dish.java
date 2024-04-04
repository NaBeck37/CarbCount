package nl.miwnn.se13.nadine.carbohydrates.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * Nadine Beck
 * Represents a dish that can be eaten in a day.
 */

@Entity
public class Dish {
    @Id @GeneratedValue
    private Long dishId;
    private String name;
    private int gramsOfCarbohydrates;

    @OneToMany(mappedBy = "dish")
    private List<Meal> meals;

    @ManyToMany
    private Set<Ingredient> ingredients;

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

    public int getGramsOfCarbohydrates() {
        return gramsOfCarbohydrates;
    }

    public void setGramsOfCarbohydrates(int gramsOfCarbohydrates) {
        this.gramsOfCarbohydrates = gramsOfCarbohydrates;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
