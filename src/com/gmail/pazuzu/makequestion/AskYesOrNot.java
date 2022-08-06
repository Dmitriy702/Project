package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.util.KeyboardLine;

public class AskYesOrNot implements IMakeQuestion<Boolean>
{
    private final KeyboardLine line;

    public AskYesOrNot(KeyboardLine inputData)
    {
        this.line = inputData;
    }

    @Override
    public Boolean makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = line.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = line.input();
        }
        return answer.length() > 0;
    }
}
