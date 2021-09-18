package pl.zini.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role")
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
