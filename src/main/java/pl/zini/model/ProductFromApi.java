package pl.zini.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductFromApi {

    private Long id;
    @JsonProperty("product_name_pl")
    private String name;
    @JsonProperty("product_name")
    private String name2;
    @JsonProperty("brands")
    private String brand;
    private BigDecimal calories;
    private BigDecimal carbs;
    private BigDecimal proteins;
    private BigDecimal fat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        if (name2.equals("")) {
            this.name2 = name2;
        } else {
            this.name2 = "Brak nazwy produktu";
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (!brand.equals("")) {
            this.brand = brand;
        } else {
            this.brand = "Brak producenta";
        }
    }

    public Number getCalories() {
        return calories;
    }

    public void setCalories(Number calories) {
        this.calories = (new BigDecimal(calories.doubleValue())).setScale(2, RoundingMode.HALF_UP);
        ;
    }

    public Number getCarbs() {
        return carbs;
    }

    public void setCarbs(Number carbs) {
        this.carbs = (new BigDecimal(carbs.doubleValue())).setScale(2, RoundingMode.HALF_UP);
    }

    public Number getProteins() {
        return proteins;
    }

    public void setProteins(Number proteins) {
        this.proteins = (new BigDecimal(proteins.doubleValue())).setScale(2, RoundingMode.HALF_UP);
    }

    public Number getFat() {
        return fat;
    }

    public void setFat(Number fat) {
        this.fat = (new BigDecimal(fat.doubleValue())).setScale(2, RoundingMode.HALF_UP);
    }

    @JsonProperty("nutriments")
    private void unpackNested(Map<String, Object> nutriments) {
        if (nutriments.get("energy-kcal_100g") != null) {
            this.calories = (new BigDecimal(((Number) nutriments.get("energy-kcal_100g")).doubleValue())).setScale(2, RoundingMode.HALF_UP);
        } else {
            this.calories = BigDecimal.valueOf(0);
        }
        if (nutriments.get("carbohydrates_100g") != null) {
            this.carbs = (new BigDecimal(((Number) nutriments.get("carbohydrates_100g")).doubleValue())).setScale(2, RoundingMode.HALF_UP);
        } else {
            this.carbs = BigDecimal.valueOf(0);
        }
        if (nutriments.get("proteins_100g") != null) {
            this.proteins = (new BigDecimal(((Number) nutriments.get("proteins_100g")).doubleValue())).setScale(2, RoundingMode.HALF_UP);
        } else {
            this.proteins = BigDecimal.valueOf(0);
        }
        if (nutriments.get("fat_100g") != null) {
            this.fat = (new BigDecimal(((Number) nutriments.get("fat_100g")).doubleValue())).setScale(2, RoundingMode.HALF_UP);
        } else {
            this.fat = BigDecimal.valueOf(0);
        }
    }

    @Override
    public String toString() {
        return "ProductFromApi{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", calories=" + calories +
                ", carbs=" + carbs +
                ", proteins=" + proteins +
                ", fat=" + fat +
                "}\n";
    }
}
