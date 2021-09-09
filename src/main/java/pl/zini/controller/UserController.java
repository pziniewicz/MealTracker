package pl.zini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zini.model.User;
import pl.zini.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String create(Long id, Model model) {
        User user;
        if (id != null) {
            user = userService.getById(id);
        } else {
            user = new User();
        }
        model.addAttribute(user);
        return "createUser";
    }

    @PostMapping("/user/create")
    public String create(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "createUser";
        }
        userService.save(user);
        return "redirect:/user/";
    }

    @RequestMapping("/user")
    public String getAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("categories", userList);
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        User user = userService.getById(Long.parseLong(id));
        userService.delete(user);
        return "redirect:/user/";
    }

}
