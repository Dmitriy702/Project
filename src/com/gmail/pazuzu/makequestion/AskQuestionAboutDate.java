package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.util.DateUtil;
import com.gmail.pazuzu.util.KeyboardLine;

import java.time.LocalDate;

public class AskQuestionAboutDate implements IMakeQuestion<LocalDate>
{
    private final KeyboardLine line;
    private final DateUtil dataMaker;

    public AskQuestionAboutDate(KeyboardLine inputData, DateUtil dateMaker)
    {
        this.line = inputData;
        this.dataMaker = dateMaker;
    }

    @Override
    public LocalDate makeQuestion(QuestionInfoConstant questionInfo)
    {
        System.out.println(questionInfo.question);
        String answer = line.input();
        while (!answer.matches(questionInfo.regex.toString()))
        {
            System.out.println(questionInfo.exception);
            System.out.println(questionInfo.question);
            answer = line.input();
        }
        return dataMaker.parse(answer);
    }
}
