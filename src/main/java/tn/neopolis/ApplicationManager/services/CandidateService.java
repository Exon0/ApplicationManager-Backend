
package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.neopolis.ApplicationManager.exceptions.CandidateNotFoundException;
import tn.neopolis.ApplicationManager.models.Candidate;
import tn.neopolis.ApplicationManager.repositories.CandidateRepository;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;


    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();

    }


    public Candidate getCandidateById(Integer id) throws CandidateNotFoundException{
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found"));
        return candidate;
    }

    public Candidate CreateCandidate(Candidate candidate){
        Candidate candidate1 = candidateRepository.save(candidate);
        return candidate1;
    }

    public Candidate updateCandidate(Candidate candidate) throws CandidateNotFoundException {
        return candidateRepository.save(candidate);
    }

    public void deleteCandidateById(Integer id){
        candidateRepository.deleteById(id);
    }
}

