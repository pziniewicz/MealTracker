package pl.zini.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.Meal;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;
import pl.zini.service.MealNameService;
import pl.zini.service.MealService;
import pl.zini.service.PlanService;
import pl.zini.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Configuration
@RequestMapping("/meal")
public class MealController {

    private final MealService mealService;
    private final HttpServletRequest request;
    private final PlanService planService;
    private final UserServiceImpl userService;
    private final MealNameService mealNameService;

    public MealController(MealService mealService, HttpServletRequest request, PlanService planService, UserServiceImpl userService, MealNameService mealNameService) {
        this.mealService = mealService;
        this.request = request;
        this.planService = planService;
        this.userService = userService;
        this.mealNameService = mealNameService;
    }

    @RequestMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String showAll(String date, Model model) {
        Plan activePlan = planService.getByUserAndIsActive(getSessionUser(), 1);
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
        List<Meal> mealList = mealService.getByDateAndPlanAndMealName()
        return "meal/meals";
    }

    @GetMapping(value = "/create/{", produces = "text/plain;charset=UTF-8")
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


    public User getSessionUser() {
        Principal principal = request.getUserPrincipal();
        return userService.findByEmail(principal.getName());
    }
}
