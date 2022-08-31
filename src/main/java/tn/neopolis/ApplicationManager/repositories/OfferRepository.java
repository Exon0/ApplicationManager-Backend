package tn.neopolis.ApplicationManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.neopolis.ApplicationManager.models.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {
}
