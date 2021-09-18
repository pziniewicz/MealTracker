package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.User;
import pl.zini.service.MealService;
import pl.zini.service.UserServiceImpl;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("")
public class MainController {

    private final UserServiceImpl userService;
    private final MealService mealService;

    public MainController(UserServiceImpl userService, MealService mealService) {
        this.userService = userService;
        this.mealService = mealService;
    }

    @GetMapping("/")
    public String home(Model model) {
        String date = LocalDate.now()
                .toString();
        model.addAttribute("date", date);
        Map<String, Integer> data = mealService.getCaloryAndMakrosData(date, userService.getSessionUser());
        model.addAttribute("data", data);
        return "dashboard";
    }

    @GetMapping("/register")
    public String register(Long id, Model model) {
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}