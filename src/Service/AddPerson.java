package Service;

import Creator.PersonCreator;
import Data.People;
import Data.Person;
import Util.InputData;

import java.util.Set;

public class AddPerson {
    // Почему это переменная класса?
    String answer;
    private final InputData inputData;

    public AddPerson(InputData inputData)
    {
        this.inputData = inputData;
    }

    void add(){

        do {
            PersonCreator creator = new PersonCreator();

            // - берем сет пиплов
            Set<Person> people = People.getInstance().getSet();
            // - добавляем в него нового
            people.add(creator.createPerson());
            // - устанавливаем сет с новым челом вместо сета с новым челом.
            People.getInstance().setSet(people);
            /**
             * Перейди по ссылке
             * <a href="https://www.google.com/search?q=%D1%88%D1%82%D0%B0%3F&tbm=isch&ved=2ahUKEwjLqvPjhJL5AhVFpYsKHR7TC3YQ2-cCegQIABAA&oq=%D1%88%D1%82%D0%B0%3F&gs_lcp=CgNpbWcQAzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDoECAAQHjoGCAAQHhAFOggIABCxAxCDAToICAAQgAQQsQM6BAgAEEM6CwgAEIAEELEDEIMBUO8HWJsYYNgeaAJwAHgAgAHWAYgBqweSAQU0LjMuMZgBAKABAaoBC2d3cy13aXotaW1nsAEAwAEB&sclient=img&ei=nX_dYovoDcXKrgSepq-wBw&bih=930&biw=1920">label</a>
             */
            System.out.println("""
                            Если желаете добавить ещё аккаунт, введите Y.
                            Если нет нажмите ввод""");
            answer = inputData.input();
        }
        while (answer.matches("[Yy]"));
    }
}
