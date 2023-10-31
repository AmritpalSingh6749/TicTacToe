import Models.*;
import PlayingStrategy.RandomPlayingStrategy;

import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class TicTacToe {
    public static void main(String[] args) {
//        Players player1  = getHumanPlayer();
        Players player1 = selectPlayer2(getBotSymbol(Symbols.X));
        Players player2 = selectPlayer2(getBotSymbol(player1.getSymbol()));
        Game game = getGame(player1, player2);
        game.start();
        game.play();
    }

    private static Players selectPlayer2(Symbols symbol){
        System.out.println("Select Player 2 ((H)uman or (B)ot):");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s.equals("H") ? getHumanPlayer() : getBotPlayer(symbol);
    }

    private static HumanPlayer getHumanPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name: ");
        String name = sc.nextLine();
        System.out.println("Enter User Email: ");
        String email = sc.nextLine();
        System.out.println("Enter user Symbol (X or O): ");
        Symbols symbol = Symbols.valueOf(sc.nextLine());
        User user = new User(name,email,name+"photo");
        return new HumanPlayer(symbol,user);
    }
    private static Bot getBotPlayer(Symbols symbol){
         return new Bot(symbol,Level.EASY, new RandomPlayingStrategy());
    }

    private static Symbols getBotSymbol(Symbols symbol) {
        return symbol == Symbols.X ? Symbols.O : Symbols.X;
    }

    private static Game getGame(Players p1, Players p2){
        Game game = (new Game()).builder()
                .setBoard(3)
                .withPlayer(p1)
                .withPlayer(p2)
                .build();
        return game;
    }
}
