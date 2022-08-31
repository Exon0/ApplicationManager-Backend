package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.neopolis.ApplicationManager.exceptions.OfferNotFoundException;
import tn.neopolis.ApplicationManager.models.Offer;
import tn.neopolis.ApplicationManager.repositories.OfferRepository;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers(){
        List<Offer> offers = offerRepository.findAll();
        return offers;
    }

    public Offer getOfferById(Integer id) throws OfferNotFoundException {
        Offer offer= offerRepository.findById(id).orElseThrow(()->new OfferNotFoundException("Offer not Found"));
        return offer;
    }

    public Offer createOffer(Offer offer){
        Offer offer1 = offerRepository.save(offer);
        return offer1;
    }
    public Offer updateOffer(Offer offer){
        Offer offer1 = offerRepository.save(offer);
        return offer1;
    }

    public void deleteOfferById(Integer id){
        offerRepository.deleteById(id);

    }
    public void deleteAllOffers(){
        offerRepository.deleteAll();
    }

}
