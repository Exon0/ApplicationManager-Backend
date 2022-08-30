
package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.neopolis.ApplicationManager.exceptions.CandidateNotFoundException;
import tn.neopolis.ApplicationManager.models.Candidate;
import tn.neopolis.ApplicationManager.services.CandidateService;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @GetMapping(value = "")
    public List<Candidate> getCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return candidates;
    }


    @GetMapping(value = "/{id}")
    public Candidate getCandidateById(@PathVariable Integer id) throws CandidateNotFoundException {
        Candidate candidate = candidateService.getCandidateById(id);
        return candidate;
    }

    @PostMapping(value = "")
    public Candidate addCandidate(@RequestBody Candidate candidate){
        Candidate candidate1 = candidateService.CreateCandidate(candidate);
        return candidate1;
    }



    @PutMapping(value = "")
    public Candidate updateCandidate(@RequestBody Candidate candidate) throws CandidateNotFoundException {
        return candidateService.updateCandidate(candidate);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCandidatebyId(@PathVariable Integer id){
        candidateService.deleteCandidateById(id);
    }



}

