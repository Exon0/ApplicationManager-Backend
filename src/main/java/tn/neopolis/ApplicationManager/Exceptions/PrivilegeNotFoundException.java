package tn.neopolis.ApplicationManager.Exceptions;

public class PrivilegeNotFoundException extends Exception{
    private String message;
    public PrivilegeNotFoundException(String message)
    {
        this.message=message;

    }
}
