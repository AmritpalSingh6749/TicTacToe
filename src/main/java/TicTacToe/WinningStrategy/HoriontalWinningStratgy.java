package TicTacToe.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cells;
import TicTacToe.Models.Symbols;

public class HoriontalWinningStratgy implements WinningStrategy{
    @Override
    public boolean winningStrategy(Board board, Symbols symbol, int row, int column) {
        for(Cells cell : board.getCells().get(row))
            if(cell.getSymbol() != symbol)
                return false;
        return true;
    }
}
