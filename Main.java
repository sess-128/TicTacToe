package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        TableRender render = new TableRender(table);

        Game game = new Game(table, render);
        game.start();
    }
}
