package tn.neopolis.ApplicationManager.exceptions;

public class CandidateNotFoundException extends Exception {
    private String message;
    public CandidateNotFoundException(String message)
    {
        this.message=message;

    }
}
