package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.util.DateUtil;
import com.gmail.pazuzu.util.KeyboardString;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class AskQuestionAboutDate implements IMakeQuestion<LocalDate>
{
    private final KeyboardString string;

    // название переменной какое-то странное. Почти как патиМейкер =). Назови просто дейтУтил // ок!
    private final DateUtil dateUtil;

    @Override
    public LocalDate makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = string.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = string.input();
        }
        return dateUtil.parse(answer);
    }
}
