package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;
import pl.zini.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final UserServiceImpl userService;
    private final ProductServiceApi productServiceApi;
    private final HttpServletRequest request;
    private final MealNameService mealNameService;
    private final MealService mealService;

    public PlanController(PlanService planService, UserServiceImpl userService, ProductServiceApi productServiceApi, HttpServletRequest request, MealNameService mealNameService, MealService mealService) {
        this.planService = planService;
        this.userService = userService;
        this.productServiceApi = productServiceApi;
        this.request = request;
        this.mealNameService = mealNameService;

        this.mealService = mealService;
    }

    @RequestMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String showAll(Model model) {
        List<Plan> plans = planService.findByUserId(getSessionUser().getId());
        model.addAttribute("plans", plans);
        return "plan/plans";
    }

    @Transactional
    @GetMapping(value = "/create", produces = "text/plain;charset=UTF-8")
    public String create(Long id, Model model) {
        Plan plan;
        if (id != null) {
            plan = planService.getById(id);
            // editing selected meals for the day - not working because of database configurtion
//            for (MealName mealName : mealNameService.findAll()) {
//                boolean flag = false;
//                for (MealName mealNamePlan : plan.getMealNames()) {
//                    if (mealName.getName().equals(mealNamePlan.getName())) {
//                        flag = true;
//                    }
//                }
//                if (flag = false) {
//                    mealService.deleteMealsByMealNameAndPlan(mealName.getId(), plan.getId());
//                }
//            }
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
        plan.setUser(getSessionUser());
        planService.save(plan);
        return "redirect:/plan/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        Plan plan = planService.getById(Long.parseLong(id));
        planService.delete(plan);
        return "redirect:/plan/";
    }

    @GetMapping("/setActive/{id}")
    public String setActive(@PathVariable String id) {
        planService.setActive(getSessionUser().getId(),Long.parseLong(id));
        return "redirect:/plan/";
    }

    public User getSessionUser() {
        Principal principal = request.getUserPrincipal();
        return userService.findByEmail(principal.getName());
    }
}
