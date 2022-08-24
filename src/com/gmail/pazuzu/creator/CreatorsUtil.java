package com.gmail.pazuzu.creator;

import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.makequestion.AskQuestionAboutDate;
import com.gmail.pazuzu.makequestion.AskQuestionAboutSex;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import com.gmail.pazuzu.util.DateUtil;
import com.gmail.pazuzu.util.KeyboardLine;

import java.time.LocalDate;

/*
    Вызовы методов сделал пакетного уровня доступа, а класс и конструктор публичные.
    Так и должно быть?

    Ну и + все что делает этот класс, это дергает нужных IMakeQuestion.
    По факту, такую функциональность можно использовать не только для создания объектов.
    Это я к тому, что классу не подходит его теперешнее название
 */
public class CreatorsUtil
{
    // ты че, не видишь что идея жёлтым подсвечивает?)
    private final IMakeQuestion question;
    // ты че, не видишь что идея жёлтым подсвечивает?)
    private final IMakeQuestion questionAboutData;
    // ты че, не видишь что идея жёлтым подсвечивает?)
    private final IMakeQuestion questionAboutSex;
    // название переменной не соотносится с ее функциональностью
    private final QuestionsConstantsData info;

    public CreatorsUtil()
    {
        KeyboardLine line = new KeyboardLine();
        DateUtil dateUtil = new DateUtil();
        info = new QuestionsConstantsData();
        question = new AskTextQuestion(line);
        questionAboutData = new AskQuestionAboutDate(line, dateUtil);
        questionAboutSex = new AskQuestionAboutSex(line);
    }

    String country()
    {
        return (String) question.makeQuestion(info.country);
    }

    String city()
    {
        return (String) question.makeQuestion(info.city);
    }

    String street()
    {
        return (String) question.makeQuestion(info.street);
    }

    String house()
    {
        return (String) question.makeQuestion(info.house);
    }

    String apartment()
    {
        return (String) question.makeQuestion(info.apartments);
    }

    String telNumberRequired()
    {
        return (String) question.makeQuestion(info.telNumberRequired);
    }

    String telNumberOptional()
    {
        return (String) question.makeQuestion(info.telNumberOptional);
    }

    String eMail()
    {
        return (String) question.makeQuestion(info.eMail);
    }

    String name()
    {
        return (String) question.makeQuestion(info.name);
    }

    String surname()
    {
        return (String) question.makeQuestion(info.surName);
    }

    String lastname()
    {
        return (String) question.makeQuestion(info.lastName);
    }

    Sex sex()
    {
        return (Sex) questionAboutSex.makeQuestion(info.sex);
    }

    LocalDate birthday()
    {
        return (LocalDate) questionAboutData.makeQuestion(info.birthday);
    }

    String age()
    {
        return (String) question.makeQuestion(info.age);
    }
}
