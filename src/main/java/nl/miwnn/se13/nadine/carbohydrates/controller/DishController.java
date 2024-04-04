package nl.miwnn.se13.nadine.carbohydrates.controller;

import nl.miwnn.se13.nadine.carbohydrates.model.Dish;
import nl.miwnn.se13.nadine.carbohydrates.repositories.DishRepository;
import nl.miwnn.se13.nadine.carbohydrates.repositories.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Nadine Beck
 * Omschrijving
 */
@Controller
public class DishController {
   private final DishRepository dishRepository;
   private final IngredientRepository ingredientRepository;

    public DishController(DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/dish")
    private String showDishOverview(Model model) {
        model.addAttribute("allDishes", dishRepository.findAll());
        return "dishOverview";
    }

    @GetMapping("/dish/new")
    private String showDishForm(Model model) {
        model.addAttribute("dish", new Dish());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        return "dishForm";
    }

    @PostMapping("/dish/new")
    private String saveDish(@ModelAttribute("dish") Dish dishToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            dishRepository.save(dishToBeSaved);
        }
        return "redirect:/";
    }
}
