package TicTacToe;

public class TableRenderer {
    public static final int ROWS = 3, COLUMNS = 3;

    public void show(Table table) {
        for (int row = 0; row < ROWS; row++) {
            System.out.print("|");
            for (int col = 0; col < COLUMNS; col++) {
                Coordinates coordinates = new Coordinates(row, col);
                Symbol exist = table.getSymbolFromCoordinate(coordinates);
                System.out.print((exist != null ? exist : "_") + "|");
            }
            System.out.println();
        }
    }
}
