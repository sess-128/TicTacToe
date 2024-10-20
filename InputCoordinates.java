package studing;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Integer> input() {

        System.out.println("Вводите координаты! ");

        String input = scanner.nextLine();
        String regex = "^[1-3]\\s[1-3]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        ArrayList<Integer> coordinates = new ArrayList<>();

        if (input.length() != 3) {
            System.out.println("Некорректный ввод: введите координаты через пробел");
        } else if (!matcher.find()) {
            System.out.println("Некорректный ввод: нужны числа от 1 до 3");

        } else {

            try {
                String[] coordinate = input.split(" ");
                coordinates.add(Integer.parseInt(coordinate[0]));
                coordinates.add(Integer.parseInt(coordinate[1]));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Аут оф баундс");
                coordinates.removeAll(coordinates);
            } catch (NumberFormatException ex) {
                System.out.println("Вводи числа, идиот!");
            }
        }

        return coordinates;
    }
}
