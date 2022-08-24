package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.People;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import com.gmail.pazuzu.util.KeyboardLine;

import java.util.List;
import java.util.Set;

public class Searcher
{
    KeyboardLine line;
    Set<Person> people;
    IMakeQuestion<String> question; // использую интерфейс идейка недовольна =(

    // ты че, не видишь что идея жёлтым подсвечивает?)
    public Searcher(IMakeQuestion question)
    {
        this.line = new KeyboardLine();
        this.people = People.getInstance().getSet();
        this.question = question;
    }

    // а здесь ты что возвращаешь
    List searchBySurName(String surname)
    {
        return people.stream().filter(person -> person.getSurname().equals(surname)).toList();
    }

    // по какому числу? числу жен или волос на левом яичке?
    Person searchByNumber(List<Person> people, int number)
    {
        return people.get(number - 1);
    }

    /*
        Шта бля за название метода?
        Мне кажется я тебе уже писал об этом, но если мне это показалось, то напоминаю,
        что отсекать людей нужно не по айди, а по чем-то более человечном.
        С рациональной точки зрения, однофамильцев родившихся в один день будет минимум.
     */
    Person searchResultMake()
    {
        if (people.size() == 0)
        {
            System.out.println("Список пуст :( ");
            return null;
        }
        else
        {
            String surname = question.makeQuestion(new QuestionsConstantsData().surName);

            List<Person> found = searchBySurName(surname);
            if (found.size() == 0)
            {
                System.out.println("Аккаунт с такой фамилией не найден!");
                return null;
            }
            else if (found.size() == 1)
            {
                return found.get(0);
            }
            else
            {
                for (int i = 0; i < found.size(); i++)
                {
                    System.out.println(found.get(i));
                    System.out.println("номер " + (i + 1));
                    System.out.println("**************************************************");
                }
                int number = Integer.parseInt(new AskTextQuestion(line).makeQuestion(new QuestionsConstantsData().accountNumber));
                if (number > 0 && number <= found.size())
                {
                    return searchByNumber(found, number);
                }
                else
                {
                    System.out.println("Аккаунт с таким номером не найден!");
                    return null;
                }
            }
        }
    }
}
