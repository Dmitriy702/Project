import java.util.Scanner;

/*
    Задумка хороша - реализация говно =)
    Суть ООП заключается в создании объектов и манипулировании даннами через вызовы методов этих объектов.
 */
public class InputData
{

    // Почему статические поля
    static Scanner scanner = new Scanner(System.in);
    static String value;

    // почему статический метод
    public static String input(String regex, Messages message)
    {
        value = scanner.nextLine();
        if (!value.matches(regex))
        {
            throw new InputException(message);
        }
        return value;
    }
}
