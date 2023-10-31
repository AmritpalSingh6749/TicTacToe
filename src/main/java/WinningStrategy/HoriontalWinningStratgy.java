package WinningStrategy;

import Models.Board;
import Models.Cells;
import Models.Symbols;

import java.util.List;

public class HoriontalWinningStratgy implements WinningStrategy{
    @Override
    public boolean winningStrategy(Board board, Symbols symbol, int row, int column) {
        for(Cells cell : board.getCells().get(row))
            if(cell.getSymbol() != symbol)
                return false;
        return true;
    }
}
