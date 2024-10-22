package TicTacToe;

public class Rules {
    private final int ROWS = 3, COLUMNS = 3, MATCHES_TO_WIN = 3;
    private final int MATCH_FOUND = 1;
    private final int MATCH_NOT_FOUND = 0;
    private final Table table;
    public Rules(Table table) {
        this.table = table;
    }

    public boolean isWin(Symbol symbol) {
        return winInRow(symbol) || winInCol(symbol) || winInDiagonalLeft(symbol) || winInDiagonalRight(symbol);
    }

    private int numValue(Coordinates coordinates, Symbol symbol) {
        return table.getSymbolFromCoordinate(coordinates) == symbol ? MATCH_FOUND : MATCH_NOT_FOUND;
    }

    private boolean winInRow(Symbol symbol) {
        for (int row = 0; row < ROWS; row++) {
            int matches = 0;
            for (int col = 0; col < COLUMNS; col++) {
                matches += numValue(new Coordinates(row, col), symbol);
            }
            if (matches == MATCHES_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private boolean winInCol(Symbol symbol) {
        for (int col = 0; col < ROWS; col++) {
            int matches = 0;
            for (int row = 0; row < COLUMNS; row++) {
                matches += numValue(new Coordinates(col, row), symbol);
            }
            if (matches == MATCHES_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private boolean winInDiagonalLeft(Symbol symbol) {
        int matches = 0;
        for (int i = 0; i < ROWS; i++) {
            matches += numValue(new Coordinates(i, i), symbol);
        }
        return matches == MATCHES_TO_WIN;
    }

    private boolean winInDiagonalRight(Symbol symbol) {
        int matches = 0;
        for (int i = 0; i < COLUMNS; i++) {
            matches += numValue(new Coordinates(i, (COLUMNS - 1) - i), symbol);
        }
        return matches == MATCHES_TO_WIN;
    }

    public boolean isDraw() {
        return table.getInputCoordinate().size() == 9;
    }
}

