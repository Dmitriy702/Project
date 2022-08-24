package com.gmail.pazuzu.data;

import java.util.HashSet;
import java.util.Set;

/*
    Плохое название класса.
 */
public class People
{
    private final Set<Person> people;
    private static People INSTANCE;

    private People()
    {
        people = new HashSet<>();
    }

    public static People getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new People();
        }
        return INSTANCE;
    }

    // Пачиму метод называется гет сет?
    public Set<Person> getSet()
    {
        return people;
    }
}
