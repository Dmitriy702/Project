package com.gmail.pazuzu.util;

import java.util.Scanner;

public class KeyboardLine
{
    private final Scanner scanner = new Scanner(System.in);

    public String input()
    {
        return scanner.nextLine();
    }
}
