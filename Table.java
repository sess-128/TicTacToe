package studing;

import java.util.ArrayList;

public class Table {
    private final int ROW_COUNT = 3;
    private final int COLUMN_COUNT = 3;
    private final char[][] field = new char[ROW_COUNT][COLUMN_COUNT];
    private final int OFFSET = 1;

    public char[][] getField() {
        return field;
    }

    public void makeMove(ArrayList<Integer> cells, char icon){
        if (isAvailableToMove(cells)){
            int row = cells.get(0) - OFFSET;
            int column = cells.get(1) - OFFSET;
            field[row][column] = icon;
        } else {
            System.out.println("Клетка занята!");
        }
    }
    private boolean isAvailableToMove(ArrayList<Integer> check){
        int row = check.get(0) - OFFSET;
        int column = check.get(1) - OFFSET;
        return field[row][column] == 0;
    }


}

