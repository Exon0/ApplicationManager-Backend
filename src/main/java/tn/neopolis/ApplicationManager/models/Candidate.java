

package tn.neopolis.ApplicationManager.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "candidate")
@PrimaryKeyJoinColumn(name = "id")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Candidate extends User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "yearsOfExperience")
    private Integer yearsOfExperience;


    @Column(name = "englishLevel")
    private String englishLevel;


    @Column(name = "frenchLevel")
    private String frenchLevel;

    @Column(name = "cv")
    private String cv;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER)
    private Set<Application> applications;


}


