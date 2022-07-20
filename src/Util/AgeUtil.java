package Util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeUtil
{
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public LocalDate parse(String strDate)
    {
        return LocalDate.parse(strDate,format);
    }
    public String reParse(LocalDate date){
        return format.format(date);
    }

    public int getAge(LocalDate birthDay)
    {
        Period period = Period.between(birthDay,LocalDate.now());
        return period.getYears();

    }
}
