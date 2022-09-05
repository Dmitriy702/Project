package com.gmail.pazuzu.creator;


import com.gmail.pazuzu.data.Contact;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class ContactCreator
{
    private final QuestionUtil utilsForQuestions;

    public Contact createContact()
    {
        boolean notSkippedNumber = true;
        boolean notSkippedEMail = true;
        Contact contact = new Contact();
        // пачиму не интерфейсного типа переменная?
        // Я то исправил, а тут нахрена они интерфейсного типа?
        // типо правило хорошего тона??
        Set<String> numbers = new HashSet<>();
        numbers.add(utilsForQuestions.telNumberRequired());
        do
        {
            String number = utilsForQuestions.telNumberOptional();
            if (number.length() > 0)
            {
                numbers.add(number);
            }
            else
            {
                notSkippedNumber = false;
            }
        } while (notSkippedNumber);
        contact.setTelNumbers(numbers);
        Set<String> eMails = new HashSet<>();
        do
        {
            String eMail = utilsForQuestions.eMail();
            if (eMail.length() > 0)
            {
                eMails.add(eMail);
            }
            else
            {
                notSkippedEMail = false;
            }
        } while (notSkippedEMail);
        contact.setEMails(eMails);
        return contact;
    }
}
