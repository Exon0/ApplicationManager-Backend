

package tn.neopolis.ApplicationManager.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
@PrimaryKeyJoinColumn(name = "id")
@Data
public class Candidate extends User{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(name = "yearsOfExperience")
    private Integer yearsOfExperience;


    @Column(name = "englishLevel")
    private String englishLevel;


    @Column(name = "frenchLevel")
    private String frenchLevel;

    @Column(name = "cv")

    private String cv;

    @Column(name = "motivationLetter")

    private String motivationLetter;




}


