package tn.neopolis.ApplicationManager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @JsonIgnore
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    @JsonIgnore
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToMany(mappedBy = "Uprivileges")
    private Set<User> users;
}

