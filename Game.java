package TicTacToe;

import java.util.ArrayList;

public class Game {
    private final Table table;
    private final TableRender render;
    private final char CELL_CROSS = 'X';
    private final char CELL_ZERO = 'O';
    private int currentPlayer;

    public Game(Table table, TableRender render) {
        this.table = table;
        this.render = render;
        this.currentPlayer = 0;
    }

    public void start() {
        GameState state = new GameState();
        render.show();

        while (true) {
            Status status = state.getCurrentStatus(table);
            if (isGameOver(status)) {
                displayResult(status);
                break;
            }
            ArrayList<Integer> cells = InputCoordinates.input();
            makeMove(cells);
            state.check(table);
            render.show();
        }

    }

    private boolean isGameOver(Status status) {
        return status != Status.CONTINUED;
    }

    private void displayResult(Status status) {
        switch (status) {
            case CROSSES_WIN: {
                System.out.println("Крестики выиграли");
                break;
            }
            case ZEROS_WIN: {
                System.out.println("Нолики выиграли");
                break;
            }
            case DRAW: {
                System.out.println("Ничья");
                break;
            }
        }
    }

    private void makeMove(ArrayList<Integer> cells) {
        char symbol = (currentPlayer % 2 == 0) ? CELL_CROSS : CELL_ZERO;
        table.makeMove(cells, symbol);
        currentPlayer++;
    }
}
