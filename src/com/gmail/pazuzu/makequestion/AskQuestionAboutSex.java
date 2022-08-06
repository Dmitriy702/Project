package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.util.KeyboardLine;

public class AskQuestionAboutSex implements IMakeQuestion<Sex>
{
    private final KeyboardLine line;

    public AskQuestionAboutSex(KeyboardLine inputData)
    {
        this.line = inputData;
    }

    @Override
    public Sex makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = line.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = line.input();
        }
        return switch (answer)
                {
                    case "m" -> Sex.MAN;
                    case "f" -> Sex.WOMAN;
                    default -> Sex.UNKNOWN;
                };
    }
}
