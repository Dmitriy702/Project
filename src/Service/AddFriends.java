package Service;

import Data.Person;

import java.util.Set;

public class AddFriends
{

    /*
        Для чего это переменные объекта?
     */ Person you;
    Person friend;

    void addFriends()
    {
        System.out.println("Нужно найти ваш аккаунт");

        /*
            Вообще неочивидное апи метда.
            Читая его, я понимаю что происходит поиск, но не понимаю как он найдет Person.
            А оказывается, в методе search() происходит опрос оператора ЭВМ на то, чтобы он фамилию ввёл,
            а если есть однофамильцы еще какие-то цифры понатыркал.
            Для класса Search и метода search опрос пользователя это лишняя работа, которая должна выполняться не там.
            Но результат этой работы должен передаваться в search и search должен вернуть что-то.

            Такая же история и для всех других мест, где у тебя происходит опрос, а потом на основе его выполняется логика.
            Я, как потенциальный пользователь твоего кода, должен понимать как его использовать и какие зависимости я должен предоставить тому
            или иному объекту, чтобы он заработал.
            На данный момент, чтобы понять надо залазить в метод и смотреть - это неправильно, такого быть не должно.

            Как возможный вариант, чтобы найти Person, Search можно сконфигурировать так
            new PersonSearcher(
                new SearchInfo(
                    new InputData()
                )
            ).find();
            где PersonSearcher - это переименованный Search
                SearchInfo - это класс, в котором происходит опрос и результат этого опроса передается в PersonSearcher
                InputData передается в конструктор SearchInfo сам знаешь для чего
         */
        you = new Search().search();
        if (you == null)
        {
            System.out.println("Аккаунт не найден!");
            return;
        }
        System.out.println("Нужно найти аккаунт вашего друга");
        friend = new Search().search();
        if (friend == null)
        {
            System.out.println("Аккаунт не найден!");
            return;
        }
        if (you.equals(friend))
        {
            System.out.println("Нельзя иметь воображаемых друзей");
        }
        else
        {
            // - берем сет друзяшек
            Set<Person> friends = you.getFriends();
            // - добавляем в него нового
            friends.add(friend);
            // - устанавливаем сет с новым другом вместо сета с новым другом.
            you.setFriends(friends);

            /**
             * Перейди по ссылке
             * <a href="https://www.google.com/search?q=%D1%88%D1%82%D0%B0%3F&tbm=isch&ved=2ahUKEwjLqvPjhJL5AhVFpYsKHR7TC3YQ2-cCegQIABAA&oq=%D1%88%D1%82%D0%B0%3F&gs_lcp=CgNpbWcQAzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDoECAAQHjoGCAAQHhAFOggIABCxAxCDAToICAAQgAQQsQM6BAgAEEM6CwgAEIAEELEDEIMBUO8HWJsYYNgeaAJwAHgAgAHWAYgBqweSAQU0LjMuMZgBAKABAaoBC2d3cy13aXotaW1nsAEAwAEB&sclient=img&ei=nX_dYovoDcXKrgSepq-wBw&bih=930&biw=1920">label</a>
             */
            System.out.println("Друг добавлен");
        }

    }
}
