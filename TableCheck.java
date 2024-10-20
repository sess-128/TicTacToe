package TicTacToe;

import java.util.ArrayList;

public class TableCheck {
    private final int COLUMN_COUNT = 3;
    private final int ROW_COUNT = 3;
    private final ArrayList<Integer> sums = new ArrayList<>();

    public ArrayList<Integer> getSums() {
        return sums;
    }

    public void checkSums(Table table) {

        char[][] field = table.getField();
        calculateCellsInColumns(field);
        calculateCellsInRows(field);
        calculateCellsInLeftDiagonal(field);
        calculateCellsInRightDiagonal(field);
    }

    private int calculateNumValue(char cellState) {
        if (cellState == 'X') {
            return 1;
        } else if (cellState == 'O') {
            return -1;
        } else {
            return 0;
        }

    }

    private void calculateCellsInRows(char[][] field) {
        for (int row = 0; row < ROW_COUNT; row++) {
            int rowSum = 0;
            for (int col = 0; col < ROW_COUNT; col++) {
                rowSum += calculateNumValue(field[row][col]);
            }
            sums.add(rowSum);
        }
    }

    private void calculateCellsInColumns(char[][] field) {
        for (int col = 0; col < COLUMN_COUNT; col++) {
            int colSum = 0;
            for (int row = 0; row < ROW_COUNT; row++) {
                colSum += calculateNumValue(field[row][col]);
            }
            sums.add(colSum);
        }
    }

    private void calculateCellsInLeftDiagonal(char[][] field) {
        int leftDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            leftDiagonalSum += calculateNumValue(field[i][i]);
        }
        sums.add(leftDiagonalSum);
    }

    private void calculateCellsInRightDiagonal(char[][] field) {
        int rightDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            rightDiagonalSum += calculateNumValue(field[i][(ROW_COUNT - 1) - i]);
        }
        sums.add(rightDiagonalSum);
    }

    public boolean isTableFull(Table table) {
        char[][] field = table.getField();

        for (char[] row : field) {
            for (char cell : row) {
                if (cell != 'X' && cell != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

}
