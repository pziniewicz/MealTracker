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

        List<Meal> meals = mealService.getByDateAndPlan(LocalDate.parse(date), activePlan.getId());
        System.out.println(meals);
        model.addAttribute("meals", meals);
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
        ingredient.setCalories(calories);
        ingredient.setCarbs(carbs);
        ingredient.setProtein(protein);
        ingredient.setFat(fat);
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

    public Map<String, Integer> getCaloryAndMakrosData(LocalDate date) {
        Map<String,Integer> data = new HashMap<>() ;
        Plan activePlan = planService.getByUserAndIsActive(getSessionUser(), 1);
        data.put("calPercent", activePlan.getCaloricDemand());
        data.put("proteinDemand", activePlan.getProteinQuantity());
        data.put("carbsDemand", activePlan.getCarbsQuantity());
        data.put("fatDemand", activePlan.getFatQuantity());

        return data;
    }

}
