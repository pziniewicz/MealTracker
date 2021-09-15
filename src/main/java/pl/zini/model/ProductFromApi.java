package pl.zini.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductFromApi {

    @JsonProperty("product_name_pl")
    private String name;
    @JsonProperty("product_name")
    private String name2;
    @JsonProperty("brands")
    private String brand;
    private Number calories;
    private Number carbs;
    private Number proteins;
    private Number fat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = name2;
        }
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Number getCalories() {
        return calories;
    }

    public void setCalories(Number calories) {
        this.calories = calories;
    }

    public Number getCarbs() {
        return carbs;
    }

    public void setCarbs(Number carbs) {
        this.carbs = carbs;
    }

    public Number getProteins() {
        return proteins;
    }

    public void setProteins(Number proteins) {
        this.proteins = proteins;
    }

    public Number getFat() {
        return fat;
    }

    public void setFat(Number fat) {
        this.fat = fat;
    }

    @JsonProperty("nutriments")
    private void unpackNested(Map<String,Object> nutriments) {
        this.calories = (Number) nutriments.get("energy-kcal_100g");
        this.carbs = (Number) nutriments.get("carbohydrates_100g");
        this.proteins = (Number) nutriments.get("proteins_100g");
        this.fat = (Number) nutriments.get("fat_100g");
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
