package TicTacToe.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Symbols;

public interface WinningStrategy {
    boolean winningStrategy(Board board, Symbols symbol, int row, int column);
}
