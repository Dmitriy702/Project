package com.gmail.pazuzu.makequestion;

import com.gmail.pazuzu.enums.Messages;
import com.gmail.pazuzu.enums.Regex;

public class QuestionInfoConstant
{
    Regex regex;
    String question;
    Messages exception;

    public QuestionInfoConstant(Regex regex, String question, Messages exception)
    {
        this.regex = regex;
        this.question = question;
        this.exception = exception;
    }
}
