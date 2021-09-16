package pl.zini.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("/meal")
public class MealController {

    @GetMapping("")
    public String showAll() {
        return "meal/meals";
    }
}
