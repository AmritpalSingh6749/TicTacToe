package TicTacToe.PlayingStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cells;

public interface PlayingStrategies {
    Cells makeMove(Board board);
}
