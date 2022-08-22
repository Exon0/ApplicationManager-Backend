package tn.neopolis.ApplicationManager.exceptions;

public class RoleNotFoundException extends Exception{
    private String message;
    public RoleNotFoundException(String message)
    {
        this.message=message;

    }
}
