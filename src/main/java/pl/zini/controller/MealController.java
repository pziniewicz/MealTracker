package pl.zini.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.*;
import pl.zini.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.*;

@Configuration
@RequestMapping("/meal")
public class MealController {

    private final MealService mealService;
    private final HttpServletRequest request;
    private final PlanService planService;
    private final UserServiceImpl userService;
    private final MealNameService mealNameService;
    private final IngredientService ingredientService;

    public MealController(MealService mealService, HttpServletRequest request, PlanService planService, UserServiceImpl userService, MealNameService mealNameService, IngredientService ingredientService) {
        this.mealService = mealService;
        this.request = request;
        this.planService = planService;
        this.userService = userService;
        this.mealNameService = mealNameService;
        this.ingredientService = ingredientService;
    }

    @Transactional
    @RequestMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String showAll(String date, Model model) {
        Plan activePlan = planService.getByUserAndIsActive(userService.getSessionUser(), 1);
        model.addAttribute("activePlan", activePlan);
        if (activePlan!= null) {
            if (date == null) {
                date = LocalDate.now().toString();
            }
            List<MealName> mealNames = activePlan.getMealNames();
            model.addAttribute("mealNames", mealNames);
            mealService.createMeals(date, activePlan);
            Map<String, Integer> data = mealService.getCaloryAndMakrosData(date, userService.getSessionUser());
            model.addAttribute("data", data);
            List<Meal> meals = mealService.getByDateAndPlan(LocalDate.parse(date), activePlan.getId());
            model.addAttribute("meals", meals);
        }
        return "meal/meals";
    }

    @GetMapping(value = "/create/", produces = "text/plain;charset=UTF-8")
    public String create(Long id, Model model) {
        Plan plan;
        if (id != null) {
            plan = planService.getById(id);
        } else {
            plan = new Plan();
        }
        List<MealName> mealNames = mealNameService.findAll();
        model.addAttribute("mealNames", mealNames);
        model.addAttribute(plan);
        return "plan/newPlan";
    }

    @PostMapping(value = "/create", produces = "text/plain;charset=UTF-8")
    public String create(@Valid Plan plan, BindingResult result) {
        if (result.hasErrors()) {
            return "plan/newPlan";
        }
        plan.setUser(userService.getSessionUser());
        planService.save(plan);
        return "redirect:/plan/";
    }

    @GetMapping(value = "/add/{date}/{mealId}/{name}/{brand}/{calories}/{carbs}/{protein}/{fat}/{productId}",
            produces = "text/plain;charset=UTF-8")
    public String add(@PathVariable String date,
                      @PathVariable Long mealId,
                      @PathVariable String name,
                      @PathVariable String brand,
                      @PathVariable BigDecimal calories,
                      @PathVariable BigDecimal carbs,
                      @PathVariable BigDecimal protein,
                      @PathVariable BigDecimal fat,
                      @PathVariable Long productId) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name.trim());
        ingredient.setBrand(brand.trim());
        ingredient.setCaloriesPer100g(calories);
        ingredient.setCarbsPer100g(carbs);
        ingredient.setProteinPer100g(protein);
        ingredient.setFatPer100g(fat);
        ingredient.setQuantity(0);
        ingredient.setProductId(productId);
        ingredientService.save(ingredient);
        Meal meal = mealService.getById(mealId);
        List<Ingredient> ingredients = meal.getIngredients();
        ingredients.add(ingredient);
        mealService.save(meal);
        return "redirect:/meal?date=" + date;
    }
}
