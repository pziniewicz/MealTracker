package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.Plan;
import pl.zini.service.PlanService;
import pl.zini.service.UserServiceImpl;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final UserServiceImpl userService;

    public PlanController(PlanService planService, UserServiceImpl userService) {
        this.planService = planService;
        this.userService = userService;
    }

    @GetMapping(value = "/create", produces = "text/plain;charset=UTF-8")
    public String create(Long id, Model model) {
        Plan plan;
        if (id != null) {
            plan = planService.getById(id);
        } else {
            plan = new Plan();
        }
        model.addAttribute(plan);
        return "plan/newPlan";
    }

    @PostMapping(value = "/create", produces = "text/plain;charset=UTF-8")
    public String create(@Valid Plan plan, BindingResult result) {
        if (result.hasErrors()) {
            return "plan/newPlan";
        }
        planService.save(plan);
        return "redirect:/plan/";
    }

    @RequestMapping("/")
    public String getAll(Model model) {
        List<Plan> plans = planService.findAll();
        model.addAttribute("plans", plans);
        return "plan/plans";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        Plan plan = planService.getById(Long.parseLong(id));
        planService.delete(plan);
        return "redirect:/plan/";
    }

    @RequestMapping(value = "/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    @Transactional
    public String get(@PathVariable Long id) {
        Plan plan = planService.getById(id);
        return "Artykul: " +  plan;
    }
}
