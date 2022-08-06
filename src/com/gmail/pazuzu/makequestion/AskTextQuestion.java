package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.util.KeyboardLine;

public class AskTextQuestion implements IMakeQuestion<String>
{
    private final KeyboardLine line;

    public AskTextQuestion(KeyboardLine line)
    {
        this.line = line;
    }

    @Override
    public String makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = line.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = line.input();
        }
        return answer;
    }
}
