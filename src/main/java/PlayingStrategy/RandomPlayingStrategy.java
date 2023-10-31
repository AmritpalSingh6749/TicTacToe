package PlayingStrategy;

import Models.Board;
import Models.Cells;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategies{
    @Override
    public Cells makeMove(Board board) {
        List<Cells> cellList = board.getEmptyCells();
        int randomIndex = (int)(Math.random() * cellList.size());
        return new Cells(cellList.get(randomIndex).getX(),cellList.get(randomIndex).getY());
    }
}
