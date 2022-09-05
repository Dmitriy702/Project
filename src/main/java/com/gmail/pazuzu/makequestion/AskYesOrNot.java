package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.util.KeyboardString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AskYesOrNot implements IMakeQuestion<Boolean>
{
    private final KeyboardString string;

    @Override
    public Boolean makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = string.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = string.input();
        }
        return answer.length() > 0;
    }
}
