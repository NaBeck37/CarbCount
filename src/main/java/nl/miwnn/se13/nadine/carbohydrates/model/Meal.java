package nl.miwnn.se13.nadine.carbohydrates.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

/**
 * Nadine Beck
 * A specific meal with its carb count.
 */
@Entity
public class Meal{
    @Id
    @GeneratedValue
    private Long mealId;

    private LocalDate dayOfEating;

    @ManyToOne
    private Dish dish;

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public LocalDate getDayOfEating() {
        return dayOfEating;
    }

    public void setDayOfEating(LocalDate dayOfEating) {
        this.dayOfEating = dayOfEating;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
