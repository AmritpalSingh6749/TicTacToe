package WinningStrategy;

import Models.Board;
import Models.Cells;
import Models.Symbols;

public class VerticalWinningStrategy implements WinningStrategy{
    @Override
    public boolean winningStrategy(Board board, Symbols symbol, int row, int column) {
        for(int i = 0 ; i<board.getSize(); i++)
            if(board.getCells().get(i).get(column).getSymbol()!=symbol)
                return false;
        return true;
    }
}
