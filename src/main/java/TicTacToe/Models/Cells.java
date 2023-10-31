package TicTacToe.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cells {
    private int x, y;
    private Symbols symbol;
    public Cells(int x, int y){
        this.x = x;
        this.y = y;
    }
}
