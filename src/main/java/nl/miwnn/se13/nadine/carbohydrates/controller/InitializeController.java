package nl.miwnn.se13.nadine.carbohydrates.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import nl.miwnn.se13.nadine.carbohydrates.model.Dish;
import nl.miwnn.se13.nadine.carbohydrates.model.Ingredient;
import nl.miwnn.se13.nadine.carbohydrates.model.Meal;
import nl.miwnn.se13.nadine.carbohydrates.repositories.DishRepository;
import nl.miwnn.se13.nadine.carbohydrates.repositories.IngredientRepository;
import nl.miwnn.se13.nadine.carbohydrates.repositories.MealRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Nadine Beck
 * Set some initial data in the database for testing purposes
 */
@Controller
public class InitializeController {
    private final IngredientRepository ingredientRepository;
    private final DishRepository dishRepository;
    private final MealRepository mealRepository;

    public InitializeController(IngredientRepository ingredientRepository,
                                DishRepository dishRepository,
                                MealRepository mealRepository) {
        this.ingredientRepository = ingredientRepository;
        this.dishRepository = dishRepository;
        this.mealRepository = mealRepository;
    }

    @GetMapping("/initialize")
    private  String initializeDB() {
        Ingredient avocado = makeIngredient("Avocado");
        Ingredient ryeBread = makeIngredient("Rye Bread");
        Ingredient egg = makeIngredient("Egg");
        Ingredient milk = makeIngredient("Milk");
        Ingredient strawberries = makeIngredient("Strawberries");
        Ingredient oats = makeIngredient("Oats");

        Dish oatmeal = makeDish("Oatmeal", 60, oats);
        Dish avoToast = makeDish("Avocado Toast", 50, ryeBread);

        makeMeal(oatmeal);
        makeMeal(avoToast);

        return "redirect:/";
    }

    private Ingredient makeIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    private Dish makeDish(String name, int carbCount, Ingredient ingredient) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setGramsOfCarbohydrates(carbCount);

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient);
        dish.setIngredients(ingredients);

        dishRepository.save(dish);
        return dish;
    }

    private Meal makeMeal(Dish dish) {
        Meal meal = new Meal();
        meal.setDish(dish);
        meal.setDayOfEating(LocalDate.of(2024, 4, 3));

        mealRepository.save(meal);
        return meal;
    }
}
