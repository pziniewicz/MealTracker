package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zini.model.User;
import pl.zini.service.UserServiceImpl;

import javax.validation.Valid;

//in the future - possibility to manage users by admin
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAll() {
        return "user/users";
    }

    //feature will be implemented at the next step
//    @GetMapping("/edit")
//    public String register(Long id, Model model) {
//        User user = userService.getSessionUser();
//        model.addAttribute(user);
//        return "register";
//    }
//
//    @PostMapping("/edit")
//    public String register(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "register";
//        }
//        userService.saveUser(user);
//        return "redirect:/login";
//    }
}
