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
import pl.zini.service.UserServiceImpl;
import pl.zini.web.dto.UserRegistrationDto;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user/create")
    public String create(Long id, Model model) {
        User user;
        if (id != null) {
            user = userServiceImpl.getById(id);
        } else {
            user = new User();
        }
        model.addAttribute(user);
        return "createUser";
    }

    @PostMapping("/user/create")
    public String create(@Valid UserRegistrationDto userRegistrationDto, BindingResult result) {
        if (result.hasErrors()) {
            return "createUser";
        }
        userServiceImpl.save(userRegistrationDto);
        return "redirect:/user/";
    }

    @RequestMapping("/user")
    public String getAll(Model model) {
        List<User> userList = userServiceImpl.findAll();
        model.addAttribute("categories", userList);
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        User user = userServiceImpl.getById(Long.parseLong(id));
        userServiceImpl.delete(user);
        return "redirect:/user/";
    }

}
