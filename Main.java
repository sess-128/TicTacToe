package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        TableRenderer renderer = new TableRenderer();
        Game game = new Game(table,renderer);

        game.start();
    }
}
