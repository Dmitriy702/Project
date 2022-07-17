import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/*
    А как из твоего описания объектов адрес и контакт можно понять к какому человеку они относятся
 */
public class Person
{
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final String surname;
    private final String lastname;
    private final int age;
    private final Date birthday;

    // Нужен енум
    private final String sex;

    // Почему не через интерфейс
    private final HashSet<Person> friends;

    /*
        Почему не через интерфейс?

        На мой взгляд, удобнее было бы не использовать здесь вообще коллекцию, а просто иметь поле Contact.
        А в объекте контакт уже иметь список телефоном и имейлов.
     */
    private final HashSet<Contact> contacts;

    // Почему не через интерфейс
    private final HashSet<Address> addresses;

    public Person(String name, String surname, String lastname, int age, Date birthday, String sex)
    {
        this.id = idCounter;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.age = age;
        this.birthday = birthday;
        this.sex = sex;

        // Зачем здесь параметризация
        this.addresses = new HashSet<Address>();
        this.contacts = new HashSet<Contact>();
        this.friends = new HashSet<Person>();
        idCounter++;
    }

    private static String name()
    {
        System.out.println("Введите имя. Не более 20 символов");
        try
        {
            return InputData.input("^([a-zA-Z]|[а-яА-Я]){1,20}$", Messages.NAME_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.NAME_EXCEPTION);
            return name();
        }
    }

    private static String surname()
    {
        System.out.println("Введите фамилию. Не более 20 символов");
        try
        {
            return InputData.input("^([a-zA-Z]|[а-яА-Я]){1,20}$", Messages.SURNAME_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.SURNAME_EXCEPTION);
            return surname();
        }
    }

    private static String lastname()
    {
        System.out.println("Введите отчество (Не более 20 символов), или нажмите ввод что бы пропустить.");
        try
        {
            return InputData.input("(^$)|(^([a-zA-Z]|[а-яА-Я]){1,20}$)", Messages.LASTNAME_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.LASTNAME_EXCEPTION);
            return lastname();
        }
    }

    /*
        А почему у тебя возраст стрингой возварщается?
     */
    private static String age()
    {
        System.out.println("Введите возрост (Не более 3х цифр), или нажмите ввод что бы пропустить.");
        try
        {
            return InputData.input("(^$)|(^([0-9]){1,3}$)", Messages.AGE_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.AGE_EXCEPTION);
            return age();
        }
    }

    /*
        А почему дата рождения это строка?
     */
    private static String birthday()
    {
        System.out.println("Введите дату рождения в формате dd-MM-yyyy");
        try
        {
            // Что это за пиздец?
            return InputData.input("^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)" + "(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)" + "0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|" + "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)" + "(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", Messages.BIRTHDAY_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.BIRTHDAY_EXCEPTION);
            return birthday();
        }
    }

    /*
        А почему пол не через енум?
        Сделал бы вообще через boolean =)
     */
    private static String sex()
    {
        System.out.println("Введите пол (ж или м), или нажмите ввод что бы пропустить.");
        try
        {
            return InputData.input("(^$)|(^ж$)|(^м$)", Messages.SEX_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.SEX_EXCEPTION);
            return sex();
        }
    }

    /*
        Метод по созданию челобрека должен создавать челобрека
        А тут ищо и адрес с контактом создается.
     */
    public static Person createPerson() throws ParseException
    {
        Person person;
        String name = name();
        String surname = surname();
        String lastname = lastname();
        String sex = sex();
        Date date = AgeUtil.parse(birthday());
        String ageStr = age();
        int age;
        if (ageStr.length() > 0)
        {
            age = Integer.parseInt(ageStr);
            while (age != AgeUtil.getAge(date))
            {
                System.out.println(Messages.BIRTHDAY_AGE_EXCEPTION);
                date = AgeUtil.parse(birthday());
                age = Integer.parseInt(age());
            }
        }
        else
        {
            age = AgeUtil.getAge(date);
        }
        person = new Person(name, surname, lastname, age, date, sex);
        String answer;
        do
        {
            person.addresses.add(Address.createAddress());
            System.out.println("Если хотите добавить новый адрес введите Y." + "\nЕсли хотите продолжить нажмите ввод");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
        } while (answer.matches("[Yy]"));

        do
        {
            person.contacts.add(Contact.createContact());
            System.out.println("Если хотите добавить новый контакт введите Y." + "\nЕсли хотите продолжить нажмите ввод");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
        } while (answer.matches("[Yy]"));
        return person;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        // toString() объекта должен выводить инфу объекта.
        // А все эти звоздочки, решеточки и прочие символы должны быть в этом методе, только если хранятся в полях объекта.
        builder.append("*******************************************\n");

        // А чего это ты в методе append используешь конкатенацию?
        // append и был придуман для конкатенации
        builder.append("Person id - " + id + "\nname - " + name + "\nsurname - " + surname);
        if (lastname.length() > 0)
        {
            builder.append("\nlastname : " + lastname);
        }
        builder.append("\nage - " + age + "\nbirthday - " + AgeUtil.sdf.format(birthday));
        if (sex.length() > 0)
        {
            builder.append("\nsex : " + sex);
        }
        builder.append("\naddresses :");
        for (Address a : addresses)
        {
            builder.append("\n" + a);
        }
        builder.append("\ncontacts :");
        for (Contact c : contacts)
        {
            builder.append("\n" + c);
        }
        if (friends.size() > 0)
        {
            builder.append("\nfriends id :");
            for (Person p : friends)
            {
                builder.append(" " + p.id + ",");
            }
        }
        builder.append("\n*******************************************");
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
        // А нахера ты айдишку сравниваешь? она ведь уникальная
        return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(lastname, person.lastname) && Objects.equals(birthday, person.birthday) && Objects.equals(sex, person.sex) && Objects.equals(friends, person.friends) && Objects.equals(contacts, person.contacts) && Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, surname, lastname, age, birthday, sex, friends, contacts, addresses);
    }

    public int getId()
    {
        return id;
    }

    public String getSurname()
    {
        return surname;
    }

    public void addFriends(Person person)
    {
        this.friends.add(person);
    }
}