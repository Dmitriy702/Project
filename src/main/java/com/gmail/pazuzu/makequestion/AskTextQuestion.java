package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.util.KeyboardString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AskTextQuestion implements IMakeQuestion<String>
{
    private final KeyboardString string;


    @Override
    public String makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = string.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = string.input();
        }
        return answer;
    }
}
