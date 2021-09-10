package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/123")
public class PlanController {




    @GetMapping(value = "/new", produces = "text/html;charset=utf-8")
    public String create(Long id, Model model) {
//       Article article;
//        if (id != null) {
//            article = articleService.getById(id);
//        } else {
//            article = new Article();
//        }
//        model.addAttribute(article);
        return "newPlan";
    }

    @GetMapping(value = "/plans", produces = "text/html;charset=utf-8")
    public String plans(Long id, Model model) {
//       Article article;
//        if (id != null) {
//            article = articleService.getById(id);
//        } else {
//            article = new Article();
//        }
//        model.addAttribute(article);
        return "plans";
    }
}
