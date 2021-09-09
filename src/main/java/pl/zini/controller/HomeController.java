package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() { return "home"; }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() { return "admin"; }


}
