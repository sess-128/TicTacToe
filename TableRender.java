package studing;

public class TableRender {
    private final Table table;

    public TableRender(Table table) {
        this.table = table;
    }

    public void show() {
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(table.getField()[i][j] + "|");
            }
            System.out.println();
        }
    }
}
