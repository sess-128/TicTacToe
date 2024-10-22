package TicTacToe;

public class Game {
    private final Table table;
    private final TableRenderer tableRenderer;

    public Game(Table table, TableRenderer tableRenderer) {
        this.table = table;
        this.tableRenderer = tableRenderer;
    }

    public void start() {
        Player playerX = new Player(Symbol.X);
        Player playerO = new Player(Symbol.O);
        Rules rules = new Rules(table);

        Player currentPlayer = playerX;
        while (true) {
            tableRenderer.show(table);
            System.out.println("Ходят " + currentPlayer.getSymbol());

            Coordinates playerTurn = InputCoordinate.input();
            if (table.isCoordinateClear(playerTurn)) {
                table.InsertSymbol(playerTurn, currentPlayer.getSymbol());
            } else {
                System.out.println("\nКлетка занята");
                continue;
            }

            if (rules.isWin(currentPlayer.getSymbol())) {
                printWin(currentPlayer.getSymbol());
                break;
            } else if (rules.isDraw()) {
                printDraw();
                break;
            }
            currentPlayer = currentPlayer == playerX ? playerO : playerX;
        }
    }

    private void printWin(Symbol symbol) {
        System.out.println("Поздравляем игрок " + symbol + " с победой!");
    }
    private void printDraw() {
        System.out.println("Увы - никто не победил");
    }
}

