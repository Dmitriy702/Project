package com.gmail.pazuzu.service;

import com.gmail.pazuzu.creator.PersonCreator;
import com.gmail.pazuzu.data.People;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.makequestion.AskYesOrNot;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import com.gmail.pazuzu.util.KeyboardLine;

public class PeoplesManager
{

    private final AskYesOrNot question;
    private final AskTextQuestion textQuestion;
    private final QuestionsConstantsData constant;

    public PeoplesManager(KeyboardLine line)
    {
        question = new AskYesOrNot(line);
        textQuestion = new AskTextQuestion(line);
        constant = new QuestionsConstantsData();
    }

    void addNewAccount()
    {
        do
        {
            People.getInstance().getSet().add(new PersonCreator().createPerson());
        } while (question.makeQuestion(constant.newAccount));
    }

    void remove()
    {
        System.out.println("Введите фамилию удаляемого аккаунта");
        Person personToRemove = new Searcher(textQuestion).searchResultMake();
        People.getInstance().getSet().remove(personToRemove);
        System.out.println("Аккаунт удалён.");
    }

    void addFriends()
    {
        System.out.println("Нужно найти ваш аккаунт");
        Person you = new Searcher(textQuestion).searchResultMake();
        if (you == null)
        {
            return;
        }
        System.out.println("Нужно найти аккаунт вашего друга");
        Person friend = new Searcher(textQuestion).searchResultMake();
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
