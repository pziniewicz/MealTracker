package pl.zini.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zini.model.CurrentUser;
import pl.zini.model.Plan;
import pl.zini.model.User;
import pl.zini.service.UserServiceImpl;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("")
public class MainController {

    private final UserServiceImpl userService;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "dashboard";
    }

//    @GetMapping("/login")
//    public String login() {
//        System.out.println("Login");
//        return "login";
//    }

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
        return "redirect:/user/";
    }

//    @GetMapping("/logout")
//    public String logout() {
//        return "redirect:/login";
//    }

//
//    @GetMapping("/dashboard")
//    public String dashboard() {
//        return "dashboard";
//    }

}