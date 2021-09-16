package pl.zini.model;

import lombok.Data;

import javax.persistence.*;

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
    private Integer calories;
    private Integer carbs;
    private Integer protein;
    private Integer fat;

}
