package tn.neopolis.ApplicationManager.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "application")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "motivationLetter")
    private String motivationLetter;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinTable(
            name = "candidate_applications",
            joinColumns = @JoinColumn(
                    name = "application_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "candidate_id"))
    private Candidate candidate;


}
