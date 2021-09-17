package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/{date}/{mealId}", produces = "text/plain;charset=UTF-8")
    @Transactional
    public String products(@PathVariable String date, @PathVariable Long mealId, @RequestParam(required = false) String search, Model model) throws IOException {
        model.addAttribute(date);
        model.addAttribute(mealId);

        if (search != null) {
            List<ProductFromApi> productList = productServiceApi.productSearch(search);
            model.addAttribute("productList", productList);
        }
        return "ingredient/ingredient";
    }
}
