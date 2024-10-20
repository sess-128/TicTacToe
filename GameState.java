package studing;

import java.util.ArrayList;

public class GameState {
    private TableCheck tableCheck;
    private ArrayList<Integer> getSums(){
        return tableCheck.getSums();
    }
    private final int SUM_TO_WIN_CROSS = 3;
    private final int SUM_TO_WIN_ZERO = -3;

    public void check(Table table) {
        tableCheck.checkSums(table);
    }

    public boolean isWinCrosses(){
        ArrayList<Integer> sums = getSums();
        return sums.contains(SUM_TO_WIN_CROSS);
    }
    public boolean isWinZeros(){
        ArrayList<Integer> sums = getSums();
        return sums.contains(SUM_TO_WIN_ZERO);
    }
    public boolean isDraw(Table table){
        return tableCheck.isTableFull(table);
    }
}
