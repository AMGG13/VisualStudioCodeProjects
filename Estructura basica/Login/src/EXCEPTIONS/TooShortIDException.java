package EXCEPTIONS;

public class TooShortIDException extends Exception{
    public TooShortIDException() {
        super("Tu nombre de usuario no puede contener menos de 4 caracteres.");
    }
}
