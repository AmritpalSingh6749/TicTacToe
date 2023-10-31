package Models;


import PlayingStrategy.PlayingStrategies;

public class Bot extends Players {
    private Level level;
    private PlayingStrategies playingStrategy;
    public Bot(Symbols symbol, Level level, PlayingStrategies playingStrategy){
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public Cells makeMove(Board board) {
        Cells cell = playingStrategy.makeMove(board);
        cell.setSymbol(getSymbol());
        return cell;
    }
}
