package pl.zini.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate date;

    @ManyToOne
    private Plan plan;

    @ManyToMany
    private List<Ingridient> ingridients;

    @ManyToOne
    @JoinColumn(name = "mealName_id")
    private MealName mealName;

}
