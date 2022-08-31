package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.neopolis.ApplicationManager.exceptions.OfferNotFoundException;
import tn.neopolis.ApplicationManager.models.Offer;
import tn.neopolis.ApplicationManager.services.OfferService;

import java.util.List;

@RestController
@RequestMapping(value = "/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping(value = "")
    public List<Offer> findAllOffers(){
        List<Offer> offers = offerService.getAllOffers();
        return offers;
    }
    @GetMapping(value = "/{id}")
    public Offer findOfferByIf(@PathVariable Integer id) throws OfferNotFoundException {
        Offer offerById = offerService.getOfferById(id);
        return offerById;
    }
    @PostMapping(value = "")
    public Offer createOffer(@RequestBody Offer offer){
        Offer offer1 = offerService.createOffer(offer);
        return offer1;
    }
    @PutMapping(value = "")
    public Offer updateOffer(@RequestBody Offer offer){
        Offer offer1 = offerService.updateOffer(offer);
        return offer1;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteOfferById(@PathVariable Integer id){
        offerService.deleteOfferById(id);
    }
    @DeleteMapping(value = "")
    public void deleteAllOffer(){
        offerService.deleteAllOffers();
    }
}
