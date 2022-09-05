package com.gmail.pazuzu.util;

import java.util.Scanner;

public class KeyboardString
{
    private static KeyboardString instance;
    private final Scanner scanner = new Scanner(System.in);

    private KeyboardString()
    {
    }

    public static KeyboardString getInstance()
    {
        if (instance == null)
        {
            instance = new KeyboardString();
        }
        return instance;
    }

    public String input()
    {
        return scanner.nextLine();
    }
}
