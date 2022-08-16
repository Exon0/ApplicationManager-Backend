package tn.neopolis.ApplicationManager.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(exclude = "invoice")
@EqualsAndHashCode(exclude = "invoice")
@Entity
@Table(name = "privilege")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    @ManyToMany(mappedBy = "Uprivileges")
    private Set<User> users;
}

