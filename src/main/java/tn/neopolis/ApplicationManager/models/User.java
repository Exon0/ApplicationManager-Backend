package tn.neopolis.ApplicationManager.models;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    public User(Long id, String userName, String email, String pwd) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.pwd = pwd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;


    @ManyToOne
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
    private Role role ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_privileges",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id"))
    private Set<Privilege> Uprivileges ;

}
