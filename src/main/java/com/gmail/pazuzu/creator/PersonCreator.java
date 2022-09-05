package com.gmail.pazuzu.creator;


import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.enums.Messages;
import com.gmail.pazuzu.util.DateUtil;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;

@AllArgsConstructor
public class PersonCreator
{
    private final DateUtil ageUtil;
    private final QuestionUtil utilsForQuestions;
    private final AddressCreator addressCreator;
    private final ContactCreator contactCreator;

    public Person createPerson()
    {
        Person person = new Person();
        person.setName(utilsForQuestions.name());
        person.setLastname(utilsForQuestions.lastname());
        person.setSurname(utilsForQuestions.surname());
        person.setSex(utilsForQuestions.sex());
        boolean loopDestroyer = true;
        do
        {
            LocalDate date = utilsForQuestions.birthday();
            String ageStr = utilsForQuestions.age();
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
