package tn.neopolis.ApplicationManager.Exceptions;

public class RoleNotFoundException extends Exception{
    private String message;
    public RoleNotFoundException(String message)
    {
        this.message=message;

    }
}
