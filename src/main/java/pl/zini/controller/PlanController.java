package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.MealName;
import pl.zini.model.Plan;
import pl.zini.model.User;
import pl.zini.service.MealNameService;
import pl.zini.service.PlanService;
import pl.zini.service.ProductServiceApi;
import pl.zini.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final UserServiceImpl userService;
    private final ProductServiceApi productServiceApi;
    private final HttpServletRequest request;
    private final MealNameService mealNameService;

    public PlanController(PlanService planService, UserServiceImpl userService, ProductServiceApi productServiceApi, HttpServletRequest request, MealNameService mealNameService) {
        this.planService = planService;
        this.userService = userService;
        this.productServiceApi = productServiceApi;
        this.request = request;
        this.mealNameService = mealNameService;
    }

    @RequestMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String showAll(Model model) {
        List<Plan> plans = planService.findByUserId(getSessionUser().getId());
        model.addAttribute("plans", plans);
        return "plan/plans";
    }

    @GetMapping(value = "/create", produces = "text/plain;charset=UTF-8")
    public String create(Long id, Model model) {
        Plan plan;
        if (id != null) {
            plan = planService.getById(id);
        } else {
            plan = new Plan();
        }
        List<MealName> mealNames = mealNames=mealNameService.findAll();
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
        List<Plan> plans = planService.findByUserId(getSessionUser().getId());
        Plan plan = planService.getById(Long.parseLong(id));
        for (Plan plan1 : plans) {
            plan1.setIsActive(0);
        }
        plan.setIsActive(1);
        planService.save(plan);
        return "redirect:/plan/";
    }

    public User getSessionUser() {
        Principal principal = request.getUserPrincipal();
        return userService.findByEmail(principal.getName());
    }

}
