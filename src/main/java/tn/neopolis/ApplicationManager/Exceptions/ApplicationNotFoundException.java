package tn.neopolis.ApplicationManager.exceptions;

public class ApplicationNotFoundException extends Exception {
    private String message;
    public ApplicationNotFoundException(String message) {
        this.message=message;
    }
}
