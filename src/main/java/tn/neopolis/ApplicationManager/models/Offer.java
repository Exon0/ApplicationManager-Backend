package tn.neopolis.ApplicationManager.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offer")
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private String title;

    private String deadline;

    private String description;

    private String internshipDuration;

    private Integer experienceRequired;

    private Double salary;

    @OneToMany(mappedBy = "offer",fetch = FetchType.EAGER)
    private List<Application> applications;








}
