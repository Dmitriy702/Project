package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.enums.Sex;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class ArmyStatistic implements Statistic
{
    private final Set<Person> people;


    @Override
    public void showStatistic()
    {
        people.stream().filter(person -> person.getSex().equals(Sex.MAN) && person.getAge() > 17 && person.getAge() < 27)
                .map(person -> person.toStringShort() + "\n*********************************************").forEach(System.out::println);
    }
}
