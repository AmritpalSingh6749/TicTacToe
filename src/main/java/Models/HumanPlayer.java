package Models;

import java.util.Scanner;

public class HumanPlayer extends Players{
    private User user;

    public HumanPlayer(Symbols symbol, User user){
        super(symbol);
        this.user = user;
    }

    @Override
    public Cells makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Cells cell = new Cells(x, y);
        cell.setSymbol(getSymbol());
        return cell;
    }
}
