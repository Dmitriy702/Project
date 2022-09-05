package com.gmail.pazuzu.makequestion;

public interface IMakeQuestion<ResultType>
{
    ResultType makeQuestion(QuestionInfoConstant info);
}
