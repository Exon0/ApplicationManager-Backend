package tn.neopolis.ApplicationManager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidat{

    @Id
    private Long id;

    private Integer yearsOfExperience;

    private enum level{
        A1,A2,B1,B2,C1,C2
    }

    private level englishLevel;

    private level frenchLevel;

    private String cv;

    private String motivationLetter;


}
