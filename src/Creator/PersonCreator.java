package Creator;

import Data.Person;
import Enum.Messages;
import Enum.Sex;
import Util.AgeUtil;
import Util.InputData;
import makequestion.IMakeQuestion;

import java.time.LocalDate;
import java.util.HashSet;

public class PersonCreator
{
    private final InputData inputData;
    private final AgeUtil ageUtil;

    private  final IMakeQuestion question;

    public Person createPerson()
    {
        Person person = new Person();
        person.setName(name());
        person.setSurname(surname());
        person.setLastname(lastname());
        person.setSex(sex());
        boolean loopDestroyer = true;
        do
        {
            LocalDate date = birthday();
            String ageStr = age();
            if (ageStr.length() == 0)
            {
                person.setBirthday(date);
                person.setAge(ageUtil.getAge(date));
                loopDestroyer = false;
            }
            else
            {
                if (Integer.parseInt(ageStr) == ageUtil.getAge(date))
                {
                    person.setBirthday(date);
                    person.setAge(ageUtil.getAge(date));
                    loopDestroyer = false;
                }
                else
                {
                    System.out.println(Messages.BIRTHDAY_AGE_EXCEPTION);
                }
            }
        } while (loopDestroyer);

        AddressCreator addressCreator = new AddressCreator();
        person.setAddresses(addressCreator.createAddresses());

        ContactCreator contactCreator = new ContactCreator();
        person.setContacts(contactCreator.createContact());

        person.setFriends(new HashSet<>());

        return person;
    }
}
