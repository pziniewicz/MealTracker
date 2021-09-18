package pl.zini.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @OneToMany(cascade={CascadeType.ALL})
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    private MealName mealName;

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", date=" + date +
                ", mealName=" + mealName +
                '}';
    }
}
