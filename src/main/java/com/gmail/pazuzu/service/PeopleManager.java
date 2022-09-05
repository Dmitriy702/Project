package com.gmail.pazuzu.service;

import com.gmail.pazuzu.creator.PersonCreator;
import com.gmail.pazuzu.data.PeopleData;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PeopleManager
{

    // из названия переменной не понятно какой вопрос? // так лучше??
    private final IMakeQuestion<Boolean> yesNoQuestion;
    private final PersonCreator personCreator;
    private final Searcher searcher;


    public void addNewAccount()
    {
        do
        {
            PeopleData.getInstance().getPeopleData().add(personCreator.createPerson());
        } while (yesNoQuestion.makeQuestion(QuestionsConstantsData.newAccount));
    }

    public void remove()
    {
        System.out.println("Введите фамилию удаляемого аккаунта");
        Person personToRemove = searcher.searchResult();
        PeopleData.getInstance().getPeopleData().remove(personToRemove);
        System.out.println("Аккаунт удалён.");
    }

    public void addFriends()
    {
        System.out.println("Нужно найти ваш аккаунт");
        Person you = searcher.searchResult();
        if (you == null)
        {
            return;
        }
        System.out.println("Нужно найти аккаунт вашего друга");
        Person friend = searcher.searchResult();
        if (friend == null)
        {
            return;
        }
        if (you.equals(friend))
        {
            System.out.println("Нельзя иметь воображаемых друзей");
        }
        else
        {
            you.getFriends().add(friend);

            System.out.println("Друг добавлен");
        }
    }
}
