package nl.miwnn.se13.nadine.carbohydrates.controller;

import nl.miwnn.se13.nadine.carbohydrates.model.Dish;
import nl.miwnn.se13.nadine.carbohydrates.model.Meal;
import nl.miwnn.se13.nadine.carbohydrates.repositories.DishRepository;
import nl.miwnn.se13.nadine.carbohydrates.repositories.MealRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Optional;


/**
 * Nadine Beck
 * Omschrijving
 */
@Controller
public class MealController {
    private final DishRepository dishRepository;
    private final MealRepository mealRepository;

    public MealController(DishRepository dishRepository, MealRepository mealRepository) {
        this.dishRepository = dishRepository;
        this.mealRepository = mealRepository;
    }

    @GetMapping({"/","/meal"})
    private String showMealOverview(Model model) {
        model.addAttribute("allMeals", mealRepository.findAll());
        return "mealOverview";
    }

    @GetMapping("/meal/new/{dishName}")
    private String createNewMeal(@PathVariable("dishName") String dishName) {
        Optional<Dish> optionalDish = dishRepository.findByName(dishName);

        if (optionalDish.isPresent()) {
            Meal meal = new Meal();
            meal.setDish(optionalDish.get());
            meal.setDayOfEating(LocalDate.now());

            mealRepository.save(meal);
        }
        return "redirect:/";
    }
}
