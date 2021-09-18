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
        Plan activePlan = planService.getByUserAndIsActive(getSessionUser(), 1);
        model.addAttribute("activePlan", activePlan);
        if (activePlan!= null) {
            List<MealName> mealNames = activePlan.getMealNames();
            model.addAttribute("mealNames", mealNames);
            for (MealName mealName : mealNames) {
                if (mealService.getByDateAndPlanAndMealName(LocalDate.parse(date), activePlan, mealName) == null) {
                    Meal meal = new Meal();
                    meal.setDate(LocalDate.parse(date));
                    meal.setPlan(activePlan);
                    meal.setMealName(mealName);
                    mealService.save(meal);
                }
            }

            Map<String, Integer> data = getCaloryAndMakrosData(date);
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
        List<MealName> mealNames = mealNames = mealNameService.findAll();
        model.addAttribute("mealNames", mealNames);
        model.addAttribute(plan);
        return "plan/newPlan";
    }

    @PostMapping(value = "/create", produces = "text/plain;charset=UTF-8")
    public String create(@Valid Plan plan, BindingResult result) {
        if (result.hasErrors()) {
            return "plan/newPlan";
        }
        plan.setUser(getSessionUser());
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

    public User getSessionUser() {
        Principal principal = request.getUserPrincipal();
        return userService.findByEmail(principal.getName());
    }

    public Map<String, Integer> getCaloryAndMakrosData(String date) {
        Map<String, Integer> data = new HashMap<>();
        Plan activePlan = planService.getByUserAndIsActive(getSessionUser(), 1);
        data.put("calDemand", activePlan.getCaloricDemand());
        data.put("proteinDemand", activePlan.getProteinQuantity());
        data.put("carbsDemand", activePlan.getCarbsQuantity());
        data.put("fatDemand", activePlan.getFatQuantity());
        List<Meal> meals = mealService.getByDateAndPlan(LocalDate.parse(date), activePlan.getId());
        Integer calories = 0;
        Integer protein = 0;
        Integer carbs = 0;
        Integer fat = 0;
        for (Meal meal : meals) {
            for (Ingredient ingredient : meal.getIngredients()) {
                calories += ingredient.getCalories()
                        .intValue();
                protein += ingredient.getProtein()
                        .intValue();
                carbs += ingredient.getCarbs()
                        .intValue();
                fat += ingredient.getFat()
                        .intValue();
            }
        }
        Integer caloriesPercent = (calories*10 / activePlan.getCaloricDemand()) *10 ;
        Integer proteinPercent = (protein*10 / activePlan.getProteinQuantity()) *10;
        Integer carbsPercent = (carbs*10 / activePlan.getCarbsQuantity()) *10;
        Integer fatPercent = (fat*10 / activePlan.getFatQuantity()) *10;

        data.put("calories", calories);
        data.put("protein", protein);
        data.put("carbs", carbs);
        data.put("fat", fat);
        data.put("caloriesPercent", caloriesPercent);
        data.put("proteinPercent", proteinPercent);
        data.put("carbsPercent", carbsPercent);
        data.put("fatPercent", fatPercent);
        return data;
    }

}
