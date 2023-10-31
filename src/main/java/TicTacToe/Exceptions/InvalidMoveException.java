package TicTacToe.Exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(){
        super("Move was invalid");
    }
}
