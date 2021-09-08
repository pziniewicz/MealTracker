package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String home() { return "index"; }
    @GetMapping("/admin")
    @ResponseBody
    public String admin() { return "admin"; }
}
