package Service;

import Creator.PersonCreator;
import Data.People;
import Data.Person;
import Util.InputData;

import java.util.Set;

public class AddPerson {
    String answer;
    InputData inputData = new InputData();
    void add(){

        do {
            PersonCreator creator = new PersonCreator();
            Set<Person> people = People.getInstance().getSet();
            people.add(creator.createPerson());
            People.getInstance().setSet(people);
            System.out.println("""
                            Если желаете добавить ещё аккаунт, введите Y.
                            Если нет нажмите ввод""");
            answer = inputData.input();
        }
        while (answer.matches("[Yy]"));
    }
}
