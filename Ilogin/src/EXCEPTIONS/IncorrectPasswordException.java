package EXCEPTIONS;

public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException() {
        super("La contraseña debe tener como minimo 8 caracteres");
    }
}
