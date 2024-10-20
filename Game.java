package studing;

import java.util.ArrayList;

public class Game {
    private final Table table;
    private final TableRender render;
    private final char CELL_CROSS = 'X';
    private final char CELL_ZERO = 'O';

    public Game(Table table, TableRender render) {
        this.table = table;
        this.render = render;
    }

    public void start() {
        GameState state = new GameState();
        render.show();
        int currentPlayer = 0;

        while (true) {
            ArrayList<Integer> cells = InputCoordinates.input();

            if (currentPlayer % 2 == 0) {
                table.makeMove(cells, CELL_CROSS);
            } else {
                table.makeMove(cells, CELL_ZERO);
            }
            state.check(table);
            render.show();
            if (state.isDraw(table) || state.isWinZeros() || state.isWinCrosses()){

            }

            currentPlayer += 1 % 2;
        }


    }
}
