package nl.miwnn.se13.nadine.carbohydrates.controller;

import nl.miwnn.se13.nadine.carbohydrates.model.Dish;
import nl.miwnn.se13.nadine.carbohydrates.repositories.DishRepository;
import nl.miwnn.se13.nadine.carbohydrates.repositories.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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
        if (dishToBeSaved.getDishId() == null
                && dishRepository.findByName(dishToBeSaved.getName()).isPresent()) {
            return "redirect:/dish/new";
        }

        if (!result.hasErrors()) {
            dishRepository.save(dishToBeSaved);
        }
        return "redirect:/";
    }

    @GetMapping("/dish/{name}/edit")
    private String showEditDishFrom(@PathVariable("name") String name, Model model) {
        Optional<Dish> dish = dishRepository.findByName(name);

        if(dish.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("dish", dish.get());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        return "dishForm";
    }

    @GetMapping("/dish/{name}")
    private String showDishdetails(@PathVariable("name") String name, Model model) {
        Optional<Dish> dish = dishRepository.findByName(name);

        if(dish.isEmpty()) {
            return "redirect:/dish";
        }

        model.addAttribute("dishToBeShown", dish.get());
        return "dishDetail";
    }

}
