package Creator;

import Data.*;
import Util.*;
import Enum.*;

import java.time.LocalDate;
import java.util.HashSet;

public class PersonCreator {
    private final InputData inputData = new InputData();
    private final AgeUtil ageUtil = new AgeUtil();


    private String name() {
        String name;
        do {
            System.out.println("Введите имя. Не более 20 символов.");
            name = inputData.input();
            if (!name.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$")) {
                System.out.println(Messages.NAME_EXCEPTION);
            }
        }
        while (!name.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"));
        return name;
    }

    private String surname() {
        String surname;
        do {
            System.out.println("Введите фамилию. Не более 20 символов.");
            surname = inputData.input();
            if (!surname.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$")) {
                System.out.println(Messages.SURNAME_EXCEPTION);
            }
        }
        while (!surname.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"));
        return surname;
    }

    private String lastname() {
        String lastname;
        do {
            System.out.println("Введите отчество (Не более 20 символов), или нажмите ввод что бы пропустить.");
            lastname = inputData.input();
            if (!lastname.matches("(^$)|(^([a-zA-Z]|[а-яА-Я]){1,20}$)")) {
                System.out.println(Messages.LASTNAME_EXCEPTION);
            }
        }
        while (!lastname.matches("(^$)|(^([a-zA-Z]|[а-яА-Я]){1,20}$)"));
        return lastname;
    }


    private String age() {
        String age;
        do {
            System.out.println("Введите возраст (Не более 3х цифр), или нажмите ввод что бы пропустить.");
            age = inputData.input();
            if (!age.matches("(^$)|(^([0-9]){1,3}$)")) {
                System.out.println(Messages.AGE_EXCEPTION);
            }
        }
        while (!age.matches("(^$)|(^([0-9]){1,3}$)"));
        return age;
    }


    private LocalDate birthday() {
        String date;
        do {
            System.out.println("Введите дату рождения в формате dd-MM-yyyy");
            date = inputData.input();
            // Что это за пиздец? + я рад, что ты оценил!
            if (!date.matches("^(?:31(-)(?:0?[13578]|1[02])\\1|(?:29|30)(-)(?:" +
                    "0?[1,3-9]|1[0-2])\\2)(?:1[6-9]|[2-9]\\d)?\\d{2}$|^29(-)0?2" +
                    "\\3(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|" +
                    "[2468][048]|[3579][26])00)$|^(?:0?[1-9]|1\\d|2[0-8])(-)" +
                    "(?:0?[1-9]|1[0-2])\\4(?:1[6-9]|[2-9]\\d)?\\d{2}$")) {
                System.out.println(Messages.BIRTHDAY_EXCEPTION);
            }
        }
        while (!date.matches("^(?:31(-)(?:0?[13578]|1[02])\\1|(?:29|30)(-)(?:" +
                "0?[1,3-9]|1[0-2])\\2)(?:1[6-9]|[2-9]\\d)?\\d{2}$|^29(-)0?2" +
                "\\3(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|" +
                "[2468][048]|[3579][26])00)$|^(?:0?[1-9]|1\\d|2[0-8])(-)" +
                "(?:0?[1-9]|1[0-2])\\4(?:1[6-9]|[2-9]\\d)?\\d{2}$")) ;
        return ageUtil.parse(date);


    }


    private Sex sex() {
        String sex;
        do {
            System.out.println("Введите пол (ж или м), или нажмите ввод что бы пропустить.");

            sex = inputData.input();
            if (!sex.matches("(^$)|(^ж$)|(^м$)")) {
                System.out.println(Messages.SEX_EXCEPTION);
            }
        }
        while (!sex.matches("(^$)|(^ж$)|(^м$)"));
        return switch (sex) {
            case "м" -> Sex.MAN;
            case "ж" -> Sex.WOMAN;
            default -> Sex.UNKNOWN;
        };
    }


    public Person createPerson() {
        Person person = new Person();
        PersonCreator creator = new PersonCreator();
        person.setName(creator.name());
        person.setSurname(creator.surname());
        person.setLastname(creator.lastname());
        person.setSex(creator.sex());
        boolean loopDestroyer = true;
        do {
            LocalDate date = creator.birthday();
            String ageStr = creator.age();
            if (ageStr.length() == 0) {
                person.setBirthday(date);
                person.setAge(ageUtil.getAge(date));
                loopDestroyer=false;
            } else {
                if (Integer.parseInt(ageStr) == ageUtil.getAge(date)) {
                    person.setBirthday(date);
                    person.setAge(ageUtil.getAge(date));
                    loopDestroyer=false;
                } else {
                    System.out.println(Messages.BIRTHDAY_AGE_EXCEPTION);
                }
            }
        }while (loopDestroyer);

        AddressCreator addressCreator = new AddressCreator();
        person.setAddresses(addressCreator.createAddresses());

        ContactCreator contactCreator = new ContactCreator();
        person.setContacts(contactCreator.createContact());

        person.setFriends(new HashSet<>());

        return person;
    }
}
