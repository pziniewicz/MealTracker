package pl.zini.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.zini.model.CurrentUser;
import pl.zini.model.User;
import pl.zini.service.UserServiceImpl;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("")
public class MainController {

    private final UserServiceImpl userService;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/register")
    public String register(Long id, Model model) {
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    @PostMapping("/register")
    public String create(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/user/";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "this is user id " + entityUser.getId();
    }
}