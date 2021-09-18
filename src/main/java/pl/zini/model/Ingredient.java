package pl.zini.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private BigDecimal calories;
    private BigDecimal carbs;
    private BigDecimal protein;
    private BigDecimal fat;
    private BigDecimal caloriesPer100g;
    private BigDecimal carbsPer100g;
    private BigDecimal proteinPer100g;
    private BigDecimal fatPer100g;
    private Long productId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "meal_id")
    private Meal meal;

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.calories = recount(caloriesPer100g);
        this.carbs = recount(carbsPer100g);
        this.protein = recount(proteinPer100g);
        this.fat = recount(fatPer100g);
    }

    public BigDecimal recount(BigDecimal number) {
        BigDecimal result = number.divide(BigDecimal.valueOf(100));
        result = result.multiply(new BigDecimal(quantity));
        return result;
    }


}
