package pl.zini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.zini.service.IngridientServiceApi;

import java.io.IOException;

@Controller
@RequestMapping("/json")
public class JsonReadController {


    private final IngridientServiceApi ingridientServiceApi;

    public JsonReadController(IngridientServiceApi ingridientServiceApi) {
        this.ingridientServiceApi = ingridientServiceApi;
    }

    @GetMapping("/{search}")
    @ResponseBody
    public String show(@PathVariable String search) throws IOException {
        return ingridientServiceApi.productSearch(search).toString();
    }

}
