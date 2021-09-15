package pl.zini.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.zini.model.ProductFromApi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class IngridientServiceApi {

    public List<ProductFromApi> productSearch(String productName) throws IOException {
    String urlAddress = "https://pl.openfoodfacts.org/cgi/search.pl?search_terms="
            + productName + "&search_simple=1&action=process&json=1";
    URL url = new URL(urlAddress);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readValue(url, JsonNode.class);
    JsonNode products =  node.get("products");
    List<ProductFromApi> productFromApiList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            ProductFromApi product = new ObjectMapper()
                    .readerFor(ProductFromApi.class)
                    .readValue(products.get(i));
            productFromApiList.add(product);
        }
        return productFromApiList;
    }
}
