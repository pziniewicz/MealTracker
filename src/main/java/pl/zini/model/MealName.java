package pl.zini.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meal_names")
public class MealName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
//    private Long order;

}
