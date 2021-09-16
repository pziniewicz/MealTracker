package pl.zini.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "meals", indexes = {
        @Index(name = "idx_meal_mealname_id", columnList = "mealName_id")
})
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate date;

    @ManyToOne
    private Plan plan;

    @OneToMany
    private List<Ingridient> ingridients;

    @ManyToOne
    private MealName mealName;


}
