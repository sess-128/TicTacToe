package TicTacToe;

import java.util.ArrayList;

public class GameState {
    private final TableCheck tableCheck;

    public GameState() {
        this.tableCheck = new TableCheck();
    }

    private ArrayList<Integer> getSums() {
        return tableCheck.getSums();
    }

    private final int SUM_TO_WIN_CROSS = 3;
    private final int SUM_TO_WIN_ZERO = -3;

    public void check(Table table) {
        tableCheck.checkSums(table);
    }

    public Status getCurrentStatus(Table table) {
        if (isWinCrosses()) {
            return Status.CROSSES_WIN;
        } else if (isWinZeros()) {
            return Status.ZEROS_WIN;
        } else if (isDraw(table)) {
            return Status.DRAW;
        }
        return Status.CONTINUED;
    }

    public boolean isWinCrosses() {
        ArrayList<Integer> sums = getSums();
        return sums.contains(SUM_TO_WIN_CROSS);
    }

    public boolean isWinZeros() {
        ArrayList<Integer> sums = getSums();
        return sums.contains(SUM_TO_WIN_ZERO);
    }

    public boolean isDraw(Table table) {
        return tableCheck.isTableFull(table);
    }
}
