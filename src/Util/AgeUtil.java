package Util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/*
    - Между методами должна быть одна пустая строка.
    - Почему класс называется AgeUtil - судя по метолам в нем он возвращает LocalDate из строки и наоборот и это необязательно должен быть возраст.
    - Не reParse, а как минимум stringFromDate.
    - getAge не совсем корректное название, потому что геттер как правило просто возвращает значение и не принимает параметы.
      А у тебя там происходят вычисления.
 */
public class AgeUtil
{
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public LocalDate parse(String strDate)
    {
        return LocalDate.parse(strDate, format);
    }

    public String reParse(LocalDate date)
    {
        return format.format(date);
    }

    public int getAge(LocalDate birthDay)
    {
        Period period = Period.between(birthDay, LocalDate.now());
        return period.getYears();

    }
}
