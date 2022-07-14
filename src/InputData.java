import java.util.Scanner;

public class InputData {
    static Scanner scanner = new Scanner(System.in);
    static String value;
    public static String input(String regex, Messages message) {
        value = scanner.nextLine();
        if (!value.matches(regex)) {
            throw new InputException(message);
        }
        return value;
    }
}
