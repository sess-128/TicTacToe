package TicTacToe;

import java.util.HashMap;

public class Table {

    HashMap<Coordinates, Symbol> inputCoordinate = new HashMap<>();

    public HashMap<Coordinates, Symbol> getInputCoordinate() {
        return inputCoordinate;
    }

    public void InsertSymbol(Coordinates coordinates, Symbol symbol) {
        inputCoordinate.put(coordinates, symbol);
    }

    public Symbol getSymbolFromCoordinate(Coordinates coordinates) {
        return inputCoordinate.get(coordinates);
    }

    public boolean isCoordinateClear(Coordinates coordinates) {
        return !inputCoordinate.containsKey(coordinates);
    }


}
