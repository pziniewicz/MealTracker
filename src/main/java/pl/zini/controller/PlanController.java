package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.CurrentUser;
import pl.zini.model.Plan;
import pl.zini.model.User;
import pl.zini.service.PlanService;
import pl.zini.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
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
    public String create(@Valid Plan plan, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "plan/newPlan";
        }
        Principal principal = request.getUserPrincipal();
        plan.setUser(userService.findByEmail(principal.getName()));
        planService.save(plan);
        return "redirect:/plan/";
    }

    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String getAll(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        List<Plan> plans = planService.findByUserId((userService.findByEmail(principal.getName())).getId());
        model.addAttribute("plans", plans);
        return "plan/plans";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        Plan plan = planService.getById(Long.parseLong(id));
        planService.delete(plan);
        return "redirect:/plan/";
    }

    @GetMapping("/setActive/{id}")
    public String setActive(@PathVariable String id, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        List<Plan> plans = planService.findByUserId((userService.findByEmail(principal.getName())).getId());
        Plan plan = planService.getById(Long.parseLong(id));
        for (Plan plan1 : plans) {
            plan1.setIsActive(0);
        }
        plan.setIsActive(1);
        planService.save(plan);
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
