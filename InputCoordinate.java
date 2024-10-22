package TicTacToe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCoordinate {
    private static final String COORDINATE_REGEX = "^[1-3]\\s[1-3]$";
    private static final int COORDINATE_MIN = 1;
    private static final int COORDINATE_MAX = 3;
    private static final int COORDINATE_COUNT = 2;
    private static final int COORDINATE_OFFSET = 1;
    private static final Scanner scanner = new Scanner(System.in);
    public static Coordinates input() {
        while (true) {
            System.out.println("Вводите координаты в формате (x y): 1 2");
            String input = scanner.nextLine();
            String[] coordinates = input.split(" ");

            if (input.isEmpty()) {
                System.out.println("Вы ничего не ввели! Ходите!");
                continue;
            }
            if (coordinates.length != COORDINATE_COUNT) {
                System.out.println("Нужно две координаты через пробел");
                continue;
            }
            int row = Integer.parseInt(coordinates[0]) - COORDINATE_OFFSET;
            int col = Integer.parseInt(coordinates[1]) - COORDINATE_OFFSET;

            Pattern pattern = Pattern.compile(COORDINATE_REGEX);
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Нужны числа от " + COORDINATE_MIN + " до " + COORDINATE_MAX);
                continue;
            }
            return new Coordinates(row, col);
        }
    }
}

