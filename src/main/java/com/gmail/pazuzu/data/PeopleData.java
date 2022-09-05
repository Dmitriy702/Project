package com.gmail.pazuzu.data;

import java.util.HashSet;
import java.util.Set;

/*
    Плохое название класса. //Так лучше?
 */
public class PeopleData
{
    private final Set<Person> people;
    private static PeopleData INSTANCE;

    private PeopleData()
    {
        people = new HashSet<>();
    }

    public static PeopleData getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new PeopleData();
        }
        return INSTANCE;
    }

    public Set<Person> getPeopleData()
    {
        return people;
    }
}
