package com.gmail.pazuzu.creator;


import com.gmail.pazuzu.data.Contact;

import java.util.HashSet;

public class ContactCreator
{
    private final CreatorsUtil utils;

    public ContactCreator()
    {
        utils = new CreatorsUtil();
    }

    public Contact createContact()
    {
        boolean notSkippedNumber = true;
        boolean notSkippedEMail = true;
        Contact contact = new Contact();
        // пачиму не интерфейсного типа переменная?
        HashSet<String> numbers = new HashSet<>();
        numbers.add(utils.telNumberRequired());
        do
        {
            String number = utils.telNumberOptional();
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
        HashSet<String> eMails = new HashSet<>();
        do
        {
            String eMail = utils.eMail();
            if (eMail.length() > 0)
            {
                eMails.add(eMail);
            }
            else
            {
                notSkippedEMail = false;
            }
        } while (notSkippedEMail);
        contact.setMails(eMails);
        return contact;
    }
}
