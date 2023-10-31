package Models;

import Exceptions.InvalidMoveException;
import Exceptions.InvalidPlayerException;
import WinningStrategy.WinningStrategy;
import WinningStrategy.HoriontalWinningStratgy;
import WinningStrategy.VerticalWinningStrategy;
import WinningStrategy.DiagonalWinningStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Game {
    private Board board;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private List<Players> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private final List<WinningStrategy> winningStrategies = List.of(new HoriontalWinningStratgy(), new VerticalWinningStrategy(), new DiagonalWinningStrategy());

    //Builder Start
    public  Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private Game game = new Game();
        public Builder setBoard(int size){
            this.game.board = new Board(size);
            return this;
        }
        public  Builder withPlayer(Players player){
            this.game.players.add(player);
            return this;
        }
        private void validate(){
            Set<Symbols> symbolSet = game.players.stream()
                    .map(Players::getSymbol)
                    .collect(Collectors.toSet());
            if(symbolSet.size()!=game.players.size())
                throw new InvalidPlayerException();
        }
        public Game build(){
            validate();
            Game game = new Game();
            game.players = this.game.players;
            game.board = this.game.board;
            game.status = DEFAULT_STATUS;
            return game;
        }
    }
    //Builder Ends
    
    private boolean checkWinner(Symbols symbol, int row, int column){
        return winningStrategies.stream().
                anyMatch(strategy -> strategy.winningStrategy(board, symbol, row, column));
    }
    private boolean checkDraw(){
        return board.checkDraw();

    }
    public void start(){
        nextPlayerIndex = (int)(Math.random() * players.size());
        status = GameStatus.IN_PROGRESS;
    }

    public void play(){
        while(status == GameStatus.IN_PROGRESS) {
            System.out.println("Next move of player "+players.get(nextPlayerIndex).getSymbol());
            makeMove();
        }
    }

    private void makeMove(){
        //get the next player and move
        Cells move = getNextMove();
        validateMove(move);
        board.update(move);
        if(checkWinner(move.getSymbol(), move.getX(), move.getY())) {
            System.out.println("Congratulations "+ players.get(nextPlayerIndex).getSymbol() + "! You won the game!");
            this.status = GameStatus.FINISHED;
            return;
        }
        if(checkDraw()) {
            System.out.println("Game ended to a draw! ");
            this.status = GameStatus.DRAW;
        }
        updateNextPlayer();
    }

    private void updateNextPlayer() {
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    private void validateMove(Cells move) {
        int x = move.getX();
        int y = move.getY();
        int size = board.getSize();
        if(x < 0 || x >= size || y < 0 || y >= size || isCellEmpty(x,y))
            throw new InvalidMoveException();
    }

    private boolean isCellEmpty(int x, int y) {
        return board.getCells().get(x).get(y).getSymbol() != null;
    }

    private Cells getNextMove(){
        return players.get(nextPlayerIndex).makeMove(board);
    }
}
