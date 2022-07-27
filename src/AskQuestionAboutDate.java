import Util.InputData;
import makequestion.IMakeQuestion;

import java.time.LocalDate;

public class AskQuestionAboutDate implements IMakeQuestion<LocalDate>
{
    private final InputData inputData;

    public AskQuestionAboutDate(InputData inputData)
    {
        this.inputData = inputData;
    }

    @Override
    public LocalDate makeQuestion(QustionInfo question)
    {
        String date;
        do
        {
            System.out.println("Введите дату рождения в формате dd-MM-yyyy");
            date = inputData.input();
            // Что это за пиздец? + я рад, что ты оценил!
            if (!date.matches("^(?:31(-)(?:0?[13578]|1[02])\\1|(?:29|30)(-)(?:" + "0?[1,3-9]|1[0-2])\\2)(?:1[6-9]|[2-9]\\d)?\\d{2}$|^29(-)0?2" + "\\3(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|" + "[2468][048]|[3579][26])00)$|^(?:0?[1-9]|1\\d|2[0-8])(-)" + "(?:0?[1-9]|1[0-2])\\4(?:1[6-9]|[2-9]\\d)?\\d{2}$"))
            {
                System.out.println(Messages.BIRTHDAY_EXCEPTION);
            }
        } while (!date.matches("^(?:31(-)(?:0?[13578]|1[02])\\1|(?:29|30)(-)(?:" + "0?[1,3-9]|1[0-2])\\2)(?:1[6-9]|[2-9]\\d)?\\d{2}$|^29(-)0?2" + "\\3(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|" + "[2468][048]|[3579][26])00)$|^(?:0?[1-9]|1\\d|2[0-8])(-)" + "(?:0?[1-9]|1[0-2])\\4(?:1[6-9]|[2-9]\\d)?\\d{2}$"));
        return ageUtil.parse(date);


    }

}
