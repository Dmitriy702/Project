package com.gmail.pazuzu.enums;

public enum Messages
{
    COUNTRY_EXCEPTION("Неверное название страны!"),
    CITY_EXCEPTION("Неверное название города!"),
    STREET_EXCEPTION("Неверное название улицы!"),
    HOUSE_EXCEPTION("Неверный номер дома!"),
    APARTMENT_EXCEPTION("Неверный номер квартиры!"),
    TEL_NUMBER_EXCEPTION("Неверный номер телефона!"),
    EMAIL_EXCEPTION("Неверный email!"),
    NAME_EXCEPTION("Неверное имя!"),
    SURNAME_EXCEPTION("Неверная фамилия!"),
    LASTNAME_EXCEPTION("Неверное отчество!"),
    AGE_EXCEPTION("Неверный возраст!"),
    BIRTHDAY_EXCEPTION("Неверная дата рождения!"),
    SEX_EXCEPTION("Неверный пол!"),
    YES_EXCEPTION("Либо ввод либо Y!"),
    BIRTHDAY_AGE_EXCEPTION("Возраст не соответствует дате рождения!"),
    ACCOUNT_NUMBER_EXCEPTION("Некорректная цифра!");
    private final String message;

    Messages(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }
}
