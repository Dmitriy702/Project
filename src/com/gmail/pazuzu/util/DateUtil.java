package com.gmail.pazuzu.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtil
{
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public LocalDate parse(String strDate)
    {
        return LocalDate.parse(strDate, format);
    }

    public String dateToStringFormat(LocalDate date)
    {
        return format.format(date);
    }

    public int numberForCheckAge(LocalDate birthDay)
    {
        Period period = Period.between(birthDay, LocalDate.now());
        return period.getYears();

    }
}
