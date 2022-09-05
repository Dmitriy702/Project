package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.Person;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SexStatistic implements Statistic
{
    private final Set<Person> people;

    @Override
    public void showStatistic()
    {
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting())));
    }
}
