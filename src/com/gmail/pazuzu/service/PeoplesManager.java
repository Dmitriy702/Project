package com.gmail.pazuzu.service;

import com.gmail.pazuzu.creator.PersonCreator;
import com.gmail.pazuzu.data.People;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.makequestion.AskYesOrNot;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import com.gmail.pazuzu.util.KeyboardLine;

/*
    Насколько я знаю People - уже множественное число для людей
 */
public class PeoplesManager
{

    // из названия переменной не понятно какой вопрос?
    private final IMakeQuestion<Boolean> question;
    private final IMakeQuestion<String> textQuestion;

    // из названия переменной не понятно какие константы
    private final QuestionsConstantsData constant;
    private final PersonCreator personCreator;

    /*
        Когда ты делаешь такой конструктор, который в себе сам все создает, то ты создаешь не явный контракт между
        этим объектом и теми, от которых он зависит.

        Это негибко из-за того, что чтобы заменить question на другой, тебе надо лесть в конструктор и явно менять реализацию.
        Вместо того, чтобы нужную реализацию сюда передать
     */
    public PeoplesManager(KeyboardLine line)
    {
        // самому объекту PeoplesManager line не нужен, но ему нужны AskYesOrNot AskTextQuestion QuestionsConstantsData
        // так почему он не может именно эти объекты получить в конструкторе?
        question = new AskYesOrNot(line);
        textQuestion = new AskTextQuestion(line);
        constant = new QuestionsConstantsData();
    }

    /*
        Такой конструктор немного лучше, чем предыдущий, из-за следующего:
        - объявляет явный контракт - чтобы создать объект надо в него накидать нужных объектов. Он становится гибче настраиваемым.
        - из-за того, что он гибче настраиваемый ты за его пределами можешь поменять его поведение.
     */
    public PeoplesManager(IMakeQuestion<Boolean> question, IMakeQuestion<String> textQuestion, QuestionsConstantsData constant, PersonCreator personCreator)
    {
        this.question = question;
        this.textQuestion = textQuestion;
        this.constant = constant;
        this.personCreator = personCreator;
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
