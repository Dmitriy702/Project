package com.gmail.pazuzu.creator;


import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.enums.Messages;
import com.gmail.pazuzu.util.DateUtil;

import java.time.LocalDate;
import java.util.HashSet;

public class PersonCreator
{
    private final DateUtil ageUtil;
    private final CreatorsUtil utils;
    private final AddressCreator addressCreator;
    private final ContactCreator contactCreator;

    public PersonCreator()
    {
        ageUtil = new DateUtil();
        addressCreator = new AddressCreator();
        contactCreator = new ContactCreator();
        utils = new CreatorsUtil();
    }

    public Person createPerson()
    {
        Person person = new Person();
        person.setName(utils.name());
        person.setLastname(utils.lastname());
        person.setSurname(utils.surname());
        person.setSex(utils.sex());
        boolean loopDestroyer = true;
        do
        {
            LocalDate date = utils.birthday();
            String ageStr = utils.age();
            if (ageStr.length() == 0)
            {
                person.setBirthday(date);
                person.setAge(ageUtil.numberForCheckAge(date));
                loopDestroyer = false;
            }
            else
            {
                if (Integer.parseInt(ageStr) == ageUtil.numberForCheckAge(date))
                {
                    person.setBirthday(date);
                    person.setAge(ageUtil.numberForCheckAge(date));
                    loopDestroyer = false;
                }
                else
                {
                    System.out.println(Messages.BIRTHDAY_AGE_EXCEPTION);
                }
            }
        } while (loopDestroyer);

        person.setAddresses(addressCreator.createAddresses());

        person.setContacts(contactCreator.createContact());

        person.setFriends(new HashSet<>());

        return person;
    }
}
