package com.gmail.pazuzu.exception;


import com.gmail.pazuzu.enums.Messages;

public class InputException extends RuntimeException
{
    public InputException()
    {
    }

    public InputException(Messages message)
    {
        super(message.toString());
    }
}
