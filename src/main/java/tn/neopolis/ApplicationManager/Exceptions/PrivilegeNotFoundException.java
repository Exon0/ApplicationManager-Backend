package tn.neopolis.ApplicationManager.exceptions;

public class PrivilegeNotFoundException extends Exception{
    private String message;
    public PrivilegeNotFoundException(String message)
    {
        this.message=message;

    }
}
