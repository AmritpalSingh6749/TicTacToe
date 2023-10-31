package Exceptions;

public class InvalidPlayerException extends RuntimeException{
    public InvalidPlayerException(){
        super("Invalid number of players!");
    }
}
