package pl.zini.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private double height;
    private Double weight;
    private Integer gender;
    private Integer age;
    private Integer caloricDemand;
    private Integer carbsPercent;
    private Integer proteinPercent;
    private Integer fatPercent;
    private Integer carbsQuantity;
    private Integer proteinQuantity;
    private Integer fatQuantity;
    private Integer isActive;

    @OneToMany(mappedBy = "plan")
    private List<Meal> meals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setCaloricDemandAndMacros() {
        Double caloric = 0.0;
        if (this.gender == 1) {
            caloric = 655.1 + (9.567 * this.weight) + (1.85 * this.height) - (4.68 * this.age);
        } else if (this.gender == 2) {
            caloric = 66.47 + (13.7 * this.weight) + (5 * this.height) - (6.76 * this.age);
        }
        this.caloricDemand = caloric.intValue();

        setCarbsQuantity(caloric);
        setProteinQuantity(caloric);
        setFatQuantity(caloric);
    }

    public void setCarbsQuantity(Double caloric) {
        Double carbs = (((carbsPercent / 100) * caloric) / 4.15);
        this.carbsQuantity = carbs.intValue();
    }

    public void setProteinQuantity(Double caloric) {
        Double protein = ((proteinPercent / 100) * caloric) / 5.65;
        this.proteinQuantity = protein.intValue();
    }

    public void setFatQuantity(Double caloric) {
        Double fat = ((fatPercent / 100) * caloric) / 9.45;
        this.fatQuantity = fat.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Double.compare(plan.height, height) == 0 && Objects.equals(id, plan.id) && Objects.equals(name, plan.name) && Objects.equals(weight, plan.weight) && Objects.equals(gender, plan.gender) && Objects.equals(age, plan.age) && Objects.equals(caloricDemand, plan.caloricDemand) && Objects.equals(carbsPercent, plan.carbsPercent) && Objects.equals(proteinPercent, plan.proteinPercent) && Objects.equals(fatPercent, plan.fatPercent) && Objects.equals(carbsQuantity, plan.carbsQuantity) && Objects.equals(proteinQuantity, plan.proteinQuantity) && Objects.equals(fatQuantity, plan.fatQuantity) && Objects.equals(isActive, plan.isActive) && Objects.equals(meals, plan.meals) && Objects.equals(user, plan.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height, weight, gender, age, caloricDemand, carbsPercent, proteinPercent, fatPercent, carbsQuantity, proteinQuantity, fatQuantity, isActive, meals, user);
    }
}
