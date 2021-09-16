package pl.zini.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ingridients")
public class Ingridient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private Number calories;
    private Number carbs;
    private Number protein;
    private Number fat;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;


}
