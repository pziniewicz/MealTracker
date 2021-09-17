package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zini.model.ProductFromApi;
import pl.zini.service.ProductServiceApi;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private final ProductServiceApi productServiceApi;

    public IngredientController(ProductServiceApi productServiceApi) {
        this.productServiceApi = productServiceApi;
    }

    @RequestMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String products(@RequestParam(required = false) String search, Model model) throws IOException {
        if (search != null) {
            List<ProductFromApi> productList = productServiceApi.productSearch(search);
            model.addAttribute("productList", productList);
        }
        return "ingredient/ingredient";
    }
}
