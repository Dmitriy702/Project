package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.util.KeyboardString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AskQuestionAboutSex implements IMakeQuestion<Sex>
{
    private final KeyboardString string;

    @Override
    public Sex makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = string.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = string.input();
        }

        /*
            Вот это не красиво.
            По сути, ты можешь сделать в классе Sex метод, который будет принимать // !!!!класс Sex который Enum?
            параметр m или f и возвращать нужное значение из себя.

            return Sex.getByValue(answer);

            Внутри метод реализуй через стрим. Если ничего не нашлось по дефолту возвращай UNKNOWN
         */
        return switch (answer)
                {
                    case "m" -> Sex.MAN;
                    case "f" -> Sex.WOMAN;
                    default -> Sex.UNKNOWN;
                };
    }
}
