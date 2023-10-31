package Models;

import lombok.Getter;

import java.util.*;
import java.util.stream.IntStream;

@Getter
public class Board {
    private int size;
    private List<List<Cells>> cells;
    public static int TOTAL_CELLS;
    public static int FILLED_CELLS = 0;
    public Board(int size){
        this.size = size;
        TOTAL_CELLS = size*size;
        cells = initializeSize();
    }

    private List<List<Cells>> initializeSize() {
        List<List<Cells>> cellList = new ArrayList<>();
        IntStream.range(0,size).forEach(row -> {
                    List<Cells> list = new ArrayList<>();
                    IntStream.range(0,size).forEach(column -> list.add(new Cells(row, column)));
                    cellList.add(list);
                }
                );
        return cellList;
    }

    public void update(Cells move) {
        cells.get(move.getX()).get(move.getY()).setSymbol(move.getSymbol());
        FILLED_CELLS++;
        displayBoard();
    }
    public boolean checkDraw(){
        return TOTAL_CELLS == FILLED_CELLS;
    }
    public List<Cells> getEmptyCells(){
        return cells.stream().flatMap(List::stream).filter(cell -> cell.getSymbol() == null).toList();
    }
    public void displayBoard(){
        for(List<Cells> cellList : cells) {
            for (Cells cell : cellList) {
                String str = String.format("%2s",cell.getSymbol()+"");
                str = String.format("%-4s",str);
                System.out.print("|" + str + "|  ");
            }
            System.out.println();
        }

    }
}
