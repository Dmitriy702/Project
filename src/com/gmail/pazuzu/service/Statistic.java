package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.People;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.util.KeyboardLine;

import java.util.Set;

public class Statistic
{
    Set<Person> people = People.getInstance().getSet();

    void showSingle()
    {
        Person person = new Searcher(new AskTextQuestion(new KeyboardLine())).searchResultMake();
        if (person != null)
        {
            System.out.println(person);
        }
    }

    void showAll()
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

    void showAllCount()
    {
        People people = People.getInstance();
        System.out.println(people.getSet().size());
    }

    void showSexStatistic()
    {
        System.out.println("Мужчины - " + streamSexStatistic(Sex.MAN));
        System.out.println("Женщины - " + streamSexStatistic(Sex.WOMAN));
        System.out.println("Хз - " + streamSexStatistic(Sex.UNKNOWN));
    }

    int streamSexStatistic(Sex sex)
    {
        return (int) people.stream().filter(person -> person.getSex().equals(sex)).count();
    }

    void showAgeStatistic()
    {
        System.out.println("1 - 17: " + streamAgeStatistic(1, 17));
        System.out.println("18 - 35: " + streamAgeStatistic(18, 35));
        System.out.println("36 - 50: " + streamAgeStatistic(35, 50));
        System.out.println("50 - ...: " + streamAgeStatistic(50, Integer.MAX_VALUE));
    }

    private int streamAgeStatistic(int min, int max)
    {
        return (int) people.stream().filter(person -> person.getAge() >= min && person.getAge() <= max).count();
    }

    void showArmyStatistic()
    {
        people.stream().filter(person -> person.getSex().equals(Sex.MAN) && person.getAge() > 17 && person.getAge() < 27)
                .map(person -> person.toStringShort() + "\n*********************************************").forEach(System.out::println);
    }
}

