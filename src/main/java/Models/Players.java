package Models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Players {
    private Symbols symbol;

    public abstract Cells makeMove(Board board);
}
