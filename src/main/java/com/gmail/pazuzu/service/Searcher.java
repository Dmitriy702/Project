package com.gmail.pazuzu.service;

import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class Searcher
{
    private final Set<Person> people;
    private final IMakeQuestion<String> question;


    // а здесь ты что возвращаешь //Лист!!! всё что совпало с запросом
    List<Person> searchBySurName(String surname)
    {
        return people.stream().filter(person -> person.getSurname().equals(surname)).toList();
    }

    // по какому числу? числу жен или волос на левом яичке? // так збс?
    Person searchByAnswerOfUser(List<Person> people, int answer)
    {
        return people.get(answer - 1);
    }

    /*
        Шта бля за название метода?
        Мне кажется я тебе уже писал об этом, но если мне это показалось, то напоминаю,
        что отсекать людей нужно не по айди, а по чем-то более человечном.
        С рациональной точки зрения, однофамильцев родившихся в один день будет минимум.

        Несогласен!!! в друг ты забыл что создал аккаунт и по запаре создал второй такой же но более дополненый.
        Обнаружил, хочешь удалить первый калечный и тут хуяк и подводные камни.
        Это недостаток работы в консоли но как его обойти я не придумал. Точнее придумал вот так.
        P.S. Удаление идёт не по id а по номеру в списке найденых фамилий по запросу.
     */
    Person searchResult()
    {
        if (people.size() == 0)
        {
            System.out.println("Список пуст :( ");
            return null;
        }
        else
        {
            String surname = question.makeQuestion(QuestionsConstantsData.surName);

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
                int number = Integer.parseInt(question.makeQuestion(QuestionsConstantsData.accountNumber));
                if (number > 0 && number <= found.size())
                {
                    return searchByAnswerOfUser(found, number);
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
