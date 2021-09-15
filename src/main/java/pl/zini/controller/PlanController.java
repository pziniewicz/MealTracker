package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.Plan;
import pl.zini.model.ProductFromApi;
import pl.zini.service.PlanService;
import pl.zini.service.ProductServiceApi;
import pl.zini.service.UserServiceImpl;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final UserServiceImpl userService;
    private final ProductServiceApi productServiceApi;

    public PlanController(PlanService planService, UserServiceImpl userService, ProductServiceApi productServiceApi) {
        this.planService = planService;
        this.userService = userService;
        this.productServiceApi = productServiceApi;
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

    @RequestMapping(value = "/product", produces = "text/plain;charset=UTF-8")
    public String products(@RequestParam(required = false) String search, Model model) throws IOException {
        if (search != null) {
            List<ProductFromApi> productList = productServiceApi.productSearch(search);
            model.addAttribute("productList", productList);
        }
        return "products";
    }

}
