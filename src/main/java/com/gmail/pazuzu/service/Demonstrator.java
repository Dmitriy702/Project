package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.Person;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class Demonstrator
{
    private final Searcher searcherText;
    private final Set<Person> people;


    public void showSingle()
    {
        Person person = searcherText.searchResult();
        if (person != null)
        {
            System.out.println(person);
        }
    }

    public void showAll()
    {
        if (people.size() == 0)
        {
            System.out.println("Список пуст :(");
        }
        else
        {
            people.stream().map(person -> person.toStringShort() + "\n*****************************************").forEach(System.out::println);
        }
    }

    public void showAllCount()
    {
        System.out.println(people.size());
    }
}
