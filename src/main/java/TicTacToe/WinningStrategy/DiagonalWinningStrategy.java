package TicTacToe.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Symbols;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean winningStrategy(Board board, Symbols symbol, int row, int column) {
        return firstDiagonalCheck(board,symbol) || secondDiagonalCheck(board,symbol);
    }
    private boolean firstDiagonalCheck(Board board, Symbols symbol){
        for(int i=0 ; i<board.getSize() ; i++)
            if(board.getCells().get(i).get(i).getSymbol() != symbol )
                return false;
        return true;
    }
    private boolean secondDiagonalCheck(Board board, Symbols symbol){
        for(int i=0 ; i<board.getSize() ; i++)
            if(board.getCells().get(i).get(board.getSize()-(i+1)).getSymbol() != symbol )
                return false;
        return true;
    }
}
