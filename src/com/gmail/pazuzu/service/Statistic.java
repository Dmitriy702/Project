package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.People;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.util.KeyboardLine;

import java.util.Set;

/*
    Пачиму класс публичный если все в нем пакетного уровня?

    Так, на сколько я помню, уговор был такой, что функционал статистики будет реализован через интерфейс,
    который будут реализовывать конкретные классы и буду предоставлять конкретные данные статистики.
    А не то, что ты в один класс зафигачишь пачку методов выполняющих какой-то подсчет.

 */
public class Statistic
{
    // Так и было задумано, что ты оставляешь открытый доступ к этой переменной внутри пакета
    // и любой желающий из пакета может сделать с этим сетом все что захочет?
    Set<Person> people = People.getInstance().getSet();

    /*
        Какой смысл в этом методе в статистике?
        в чем статистика?
     */
    void showSingle()
    {
        Person person = new Searcher(new AskTextQuestion(new KeyboardLine())).searchResultMake();
        if (person != null)
        {
            System.out.println(person);
        }
    }

    /*
        Какой смысл в этом методе в статистике?
        в чем статистика?
     */
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
        // Зачем тебе здесь вызывать People.getInstance(); если у тебя в классе есть этот сет
        People people = People.getInstance();
        System.out.println(people.getSet().size());
    }

    // Я хотел, чтобы ты сделал это через стримы таким образом, чтобы возвращалась мапа, где ключ - пол, значение количество людей.
    // а не вот так вот
    // в стриме надо применить коллектор который вернет мапу
    void showSexStatistic()
    {
        System.out.println("Мужчины - " + streamSexStatistic(Sex.MAN));
        System.out.println("Женщины - " + streamSexStatistic(Sex.WOMAN));
        System.out.println("Хз - " + streamSexStatistic(Sex.UNKNOWN));
    }

    /*
        Слово стрим здеся как-то и не нужно.
        А если бы через цикл с ифом делал то название было бы
        forEachCycleWithIfSexStatistic? =)
     */
    int streamSexStatistic(Sex sex)
    {
        return (int) people.stream().filter(person -> person.getSex().equals(sex)).count();
    }

    // Я хотел, чтобы ты сделал это через стримы таким образом, чтобы возвращалась мапа, где ключ - пол, значение количество людей.
    // а не вот так вот
    // в стриме надо применить коллектор который вернет мапу
    void showAgeStatistic()
    {
        System.out.println("1 - 17: " + streamAgeStatistic(1, 17));
        System.out.println("18 - 35: " + streamAgeStatistic(18, 35));
        System.out.println("36 - 50: " + streamAgeStatistic(35, 50));
        System.out.println("50 - ...: " + streamAgeStatistic(50, Integer.MAX_VALUE));
    }

    /*
        Ну ты понял.
     */
    private int streamAgeStatistic(int min, int max)
    {
        return (int) people.stream().filter(person -> person.getAge() >= min && person.getAge() <= max).count();
    }

    void showArmyStatistic()
    {
        people.stream()
              .filter(person -> person.getSex().equals(Sex.MAN) && person.getAge() > 17 && person.getAge() < 27)
                .map(person -> person.toStringShort() + "\n*********************************************")
              .forEach(System.out::println);
    }
}

