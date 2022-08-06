package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.enums.Messages;
import com.gmail.pazuzu.enums.Regex;

public class QuestionsConstantsData
{
    public QuestionInfoConstant name = new QuestionInfoConstant(Regex.ONLY_20_LETTERS, "Введите имя", Messages.NAME_EXCEPTION);
    public QuestionInfoConstant lastName = new QuestionInfoConstant(Regex.NOTING_OR_20_LETTERS, "Введите отчество или нажмите ввод", Messages.LASTNAME_EXCEPTION);
    public QuestionInfoConstant surName = new QuestionInfoConstant(Regex.ONLY_20_LETTERS, "Введите фамилию", Messages.SURNAME_EXCEPTION);
    public QuestionInfoConstant sex = new QuestionInfoConstant(Regex.SEX, "Введите пол m или f или нажмите ввод чтобы пропустить", Messages.SEX_EXCEPTION);
    public QuestionInfoConstant birthday = new QuestionInfoConstant(Regex.BIRTHDAY, "Введите дату рождения в формате dd-MM-yyyy", Messages.BIRTHDAY_EXCEPTION);
    public QuestionInfoConstant age = new QuestionInfoConstant(Regex.AGE, "Введите ваш возраст", Messages.AGE_EXCEPTION);
    public QuestionInfoConstant city = new QuestionInfoConstant(Regex.ONLY_20_LETTERS, "Введите город. Не более 20 символов.", Messages.CITY_EXCEPTION);
    public QuestionInfoConstant street = new QuestionInfoConstant(Regex.ONLY_20_LETTERS, "Введите улицу. Не более 20 символов.", Messages.STREET_EXCEPTION);
    public QuestionInfoConstant country = new QuestionInfoConstant(Regex.ONLY_20_LETTERS, "Введите страну. Не более 20 символов.", Messages.COUNTRY_EXCEPTION);
    public QuestionInfoConstant house = new QuestionInfoConstant(Regex.HOUSE, "Введите номер дома. Корпус, если есть, указывать через /", Messages.HOUSE_EXCEPTION);
    public QuestionInfoConstant apartments = new QuestionInfoConstant(Regex.APARTMENTS, "Введите номер квартиры", Messages.APARTMENT_EXCEPTION);
    public QuestionInfoConstant accountNumber = new QuestionInfoConstant(Regex.ACCOUNT_NUMBER, "Аккаунт с каким конкретно номером интересует?", Messages.ACCOUNT_NUMBER_EXCEPTION);
    public QuestionInfoConstant newAddress = new QuestionInfoConstant(Regex.YES, """
            Если хотите добавить новый адрес введите Y.
            Если хотите продолжить нажмите ввод""", Messages.YES_EXCEPTION);
    public QuestionInfoConstant newAccount = new QuestionInfoConstant(Regex.YES, """
            Если желаете добавить ещё аккаунт, введите Y.
            Если нет нажмите ввод""", Messages.YES_EXCEPTION);
    public QuestionInfoConstant telNumberRequired = new QuestionInfoConstant(Regex.TEL_NUMBER_REQUIRED, """
            Введите 9 цифр номера телефона в формате:
            17ХХХХХХХ, 25ХХХХХХХ, 29ХХХХХХХ, 33ХХХХХХХ, 44ХХХХХХХ.""", Messages.TEL_NUMBER_EXCEPTION);
    public QuestionInfoConstant telNumberOptional = new QuestionInfoConstant(Regex.TEL_NUMBER_OPTIONAL, """
            Если желаете добавить ещё один номер то,
            введите 9 цифр номера телефона в формате:
            17ХХХХХХХ, 25ХХХХХХХ, 29ХХХХХХХ, 33ХХХХХХХ, 44ХХХХХХХ.
            Или нажмите ввод""", Messages.TEL_NUMBER_EXCEPTION);
    public QuestionInfoConstant eMail = new QuestionInfoConstant(Regex.EMAIL, """
            Если желаете, ведите eMail, что бы добавить его в свои контакты,
            или нажмите ввод чтобы продолжить""", Messages.EMAIL_EXCEPTION);

}
