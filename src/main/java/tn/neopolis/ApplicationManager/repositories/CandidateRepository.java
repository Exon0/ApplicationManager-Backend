
package tn.neopolis.ApplicationManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.neopolis.ApplicationManager.models.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {


}

