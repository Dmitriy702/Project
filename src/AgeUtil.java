import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
    Пачиму у тебя что не класс, что со статическим методом.
    Мы вообще-то ООП тут изучаем, а не хер пойми что на глобальных методах
    Я не доволен!
 */
public class AgeUtil
{
    // Детей своих так называть будешь
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Date parse(String strDate) throws ParseException
    {
        return sdf.parse(strDate);
    }

    // получаем возраст с даты рождения

    // Всю эту радость переши через LocalTime и Period
    public static int getAge(Date birthDay)
    {
        Calendar today = Calendar.getInstance();

        // Сам ты кал
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDay);
        if (today.before(cal))
        {
            // День рождения до сейчас??? =)
            throw new IllegalArgumentException("The birthDay is before Now. It's unbelievable!");
        }
        int yearNow = today.get(Calendar.YEAR);
        int monthNow = today.get(Calendar.MONTH);
        int dayOfMonthNow = today.get(Calendar.DAY_OF_MONTH);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth)
        {
            if (monthNow == monthBirth)
            {
                if (dayOfMonthNow < dayOfMonthBirth)
                {
                    age--;
                }
            }
            else
            {
                age--;
            }
        }
        return age;
    }
}
