package com.gmail.pazuzu.util;

import java.util.Scanner;

/*
    Тут Саня говорит, что название "линия клавиатуры" такое себе =)
    Я тут пожалуй с ним соглашусь =).
 */
public class KeyboardLine
{
    private final Scanner scanner = new Scanner(System.in);

    public String input()
    {
        return scanner.nextLine();
    }
}
