package pl.zini.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double weight;
    private String activity;
    private Integer caloricDemand;
    private Integer carbsPercent;
    private Integer proteinPercent;
    private Integer fatPercent;
    private Integer carbsQuantity;
    private Integer proteinQuantity;
    private Integer fatQuantity;
    private boolean isActive;

    @OneToMany(mappedBy = "plan")
    private List<Meal> meals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
