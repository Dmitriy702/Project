package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.Person;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AgeStatistic implements Statistic
{
    private final Set<Person> people;


    @Override
    public void showStatistic()
    {
        System.out.println(people.stream().collect(Collectors.groupingBy(person -> ((person.getAge() / 10) * 10), Collectors.counting())));
    }
}
