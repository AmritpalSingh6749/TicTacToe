package WinningStrategy;

import Models.Board;
import Models.Symbols;

public interface WinningStrategy {
    boolean winningStrategy(Board board, Symbols symbol, int row, int column);
}
