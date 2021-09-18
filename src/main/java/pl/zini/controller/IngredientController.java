package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zini.model.Ingredient;
import pl.zini.model.ProductFromApi;
import pl.zini.service.IngredientService;
import pl.zini.service.ProductServiceApi;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private final ProductServiceApi productServiceApi;
    private final IngredientService ingredientService;

    public IngredientController(ProductServiceApi productServiceApi, IngredientService ingredientService) {
        this.productServiceApi = productServiceApi;
        this.ingredientService = ingredientService;
    }

    //product search to add to meal
    @RequestMapping(value = "/search/{date}/{mealId}", produces = "text/plain;charset=UTF-8")
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

    //edit quantity of product
    @RequestMapping(value = "/edit", produces = "text/plain;charset=UTF-8")
    @Transactional
    public String edit(@RequestParam String quantity, @RequestParam String id, @RequestParam String date) throws IOException {
        ingredientService.edit(Long.parseLong(id), Integer.valueOf(quantity));
        return "redirect:/meal?date=" + date;
    }

    //deletion not working due to database configuration
    @RequestMapping(value = "/delete/{ingredientId}/{date}", produces = "text/plain;charset=UTF-8")
    @Transactional
    public String delete(@PathVariable Long ingredientId, @PathVariable String date) throws IOException {
        Ingredient ingredient = ingredientService.getById(ingredientId);
        ingredientService.delete(ingredient);
        return "redirect:/meal?date=" + date;
    }
}
