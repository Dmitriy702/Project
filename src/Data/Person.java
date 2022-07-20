package Data;

import java.time.LocalDate;
import java.util.*;
import Enum.Sex;
import Util.AgeUtil;


public class Person
{
    private static int idCounter = 1;
    private final int id;
    private String name;
    private String surname;
    private String lastname;
    private int age;
    private LocalDate birthday;
    private Sex sex;
    private Set<Person> friends;
    private Contact contacts;
    private Set<Address> addresses;

    public Person()
    {
        this.id = idCounter;
        idCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("Data.Person id - ");
        builder.append(id);
        builder.append("\nname - ");
        builder.append(name);
        if (lastname!= null&&lastname.length() > 0)
        {
            builder.append("\nlastname : ");
            builder.append(lastname);
        }
        builder.append("\nsurname - ");
        builder.append(surname);
        AgeUtil ageUtil = new AgeUtil();
        builder.append("\nage - ");
        builder.append(age);
        builder.append("\nbirthday - ");
        builder.append(ageUtil.reParse(birthday));
        builder.append("\nsex : ");
        builder.append(sex);
        builder.append("\naddresses :");
        for (Address address : addresses)
        {
            builder.append("\n");
            builder.append(address);
        }
        builder.append("\ncontacts :");
        builder.append(contacts);

        if (friends.size() > 0)
        {
            builder.append("\nfriends id :");
            for (Person p : friends)
            {
                builder.append(" ");
                builder.append(p.id);
                builder.append(",");
            }
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Person person = (Person) o;

        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(lastname, person.lastname) && Objects.equals(birthday, person.birthday) && Objects.equals(sex, person.sex) && Objects.equals(friends, person.friends) && Objects.equals(contacts, person.contacts) && Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, surname, lastname, age, birthday, sex, friends, contacts, addresses);
    }
}