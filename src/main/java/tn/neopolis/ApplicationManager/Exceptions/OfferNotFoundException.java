package tn.neopolis.ApplicationManager.exceptions;

public class OfferNotFoundException extends Exception{
    private String message;
    public OfferNotFoundException(String message)
    {
        this.message=message;

    }
}
