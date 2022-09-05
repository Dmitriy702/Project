package com.gmail.pazuzu.creator;

import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class QuestionUtil
{
    private final IMakeQuestion<String> question;
    private final IMakeQuestion<LocalDate> questionAboutData;
    private final IMakeQuestion<Sex> questionAboutSex;

    String country()
    {
        return question.makeQuestion(QuestionsConstantsData.country);
    }

    public String city()
    {
        return question.makeQuestion(QuestionsConstantsData.city);
    }

    public String street()
    {
        return question.makeQuestion(QuestionsConstantsData.street);
    }

    public String house()
    {
        return question.makeQuestion(QuestionsConstantsData.house);
    }

    public String apartment()
    {
        return question.makeQuestion(QuestionsConstantsData.apartments);
    }

    public String telNumberRequired()
    {
        return question.makeQuestion(QuestionsConstantsData.telNumberRequired);
    }

    public String telNumberOptional()
    {
        return question.makeQuestion(QuestionsConstantsData.telNumberOptional);
    }

    public String eMail()
    {
        return question.makeQuestion(QuestionsConstantsData.eMail);
    }

    public String name()
    {
        return question.makeQuestion(QuestionsConstantsData.name);
    }

    public String surname()
    {
        return question.makeQuestion(QuestionsConstantsData.surName);
    }

    public String lastname()
    {
        return question.makeQuestion(QuestionsConstantsData.lastName);
    }

    public Sex sex()
    {
        return questionAboutSex.makeQuestion(QuestionsConstantsData.sex);
    }

    public LocalDate birthday()
    {
        return questionAboutData.makeQuestion(QuestionsConstantsData.birthday);
    }

    public String age()
    {
        return question.makeQuestion(QuestionsConstantsData.age);
    }
}
