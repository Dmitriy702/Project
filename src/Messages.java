public enum Messages
{
    COUNTRY_EXCEPTION("Неверное название страны!"),
    CITY_EXCEPTION("Неверное название города!"),
    STREET_EXCEPTION("Неверное название улицы!"),
    HOUSE_EXCEPTION("Неверный номер дома!"),
    APARTMENT_EXCEPTION("Неверный номер квартиры!"),
    TEL_NUMBER_EXCEPTION("Неверный номер телефона!"),
    EMAIL_EXCEPTION("Нверный email!"),
    NAME_EXCEPTION("Неверное имя!"),
    SURNAME_EXCEPTION("Неверная фамилия!"),
    LASTNAME_EXCEPTION("Неверное отчество!"),
    AGE_EXCEPTION("Неверный возрост!"),
    BIRTHDAY_EXCEPTION("Неверная дата рждения!"),
    SEX_EXCEPTION("Неверный пол!"),
    BIRTHDAY_AGE_EXCEPTION("Возрост не соответствует дате рождения!"),
    ID_EXCEPTION("Некорректный id!");

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
