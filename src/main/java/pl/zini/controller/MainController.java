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

    @ModelAttribute("mealNames")
    public Collection<String> mealNames() {
        List<String> mealNames = new ArrayList<String>();
        mealNames.add("Śniadanie");
        mealNames.add("II śniadanie");
        mealNames.add("Lunch");
        mealNames.add("Przekąska");
        mealNames.add("Obiad");
        mealNames.add("Kolacja");
        return mealNames;
    }
    @GetMapping("/")
    public String home() {
        return "dashboard";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginPage(@RequestParam(value = "error", required = false) String error,
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
//        String errorMessge = null;
//        if(error != null) {
//            errorMessge = "Username or Password is incorrect !!";
//        }
//        if(logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessage", errorMessge);
//        return "login";
//    }
//
//    @GetMapping("/login")
//    public String login(Long id, Model model) {
//        User user = new User();
//        model.addAttribute(user);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String loggedin(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "login";
//        }
//        return "/dashboard";
//    }

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

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/plans")
    public String plans() {
        return "plans";
    }

    @GetMapping("/user/register")
    public String register() {
        return "register";
    }

    @GetMapping(value = "/plans/new", produces = "text/html;charset=utf-8")
    public String createPlan(Long id, Model model) {

        return "newPlan";
    }

    @PostMapping("/plans/new")
    public String createPlan(@Valid Plan plan, BindingResult result) {
        if (result.hasErrors()) {
            return "newPlan";
        }
        //bookService.save(book);
        return "redirect:/dashboard";
    }
}