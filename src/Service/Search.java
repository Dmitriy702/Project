package Service;

import Data.People;
import Data.Person;
import Util.InputData;

import java.util.List;
import java.util.Set;

public class Search {
    InputData inputData = new InputData();

    /*
        Зачем тебе все эти переменные нужны в классе?
        Почему не сделать их локальными метода?
     */
    String surname;
    Set<Person> people = People.getInstance().getSet();
    List<Person> found;

    void show() {
        Person person = search();
        if (person!=null) {
            System.out.println(person);
        }
    }

    Person search() {
        if (people.size()==0){
            System.out.println("Список пуст :( ");
            return null;
        }
        else {
        System.out.println("Введите фамилию.");

        // Тебя самого не смущает то, как читается inputData.input()?
        surname = inputData.input();
        /*
            Написание стримов и любые другие куски логики желательно выносить в отдельный метод с говорящим названием,
            чтобы при чтении твое кода читались слова из твоих переменных объявленных в нем,
            названия вызываемых методов, создаваемые объекты и вызываемые методы у них.

            Например:
            found = findBySurname();
         */
        found = people.stream().filter(person -> person.getSurname().equals(surname)).toList();
        if (found.size()==0){
            System.out.println("Аккаунт с такой фамилией не найден!");
            return null;
        }
        else if (found.size()==1){
            return found.get(0);
        }
        else {
            for (int i = 0; i<found.size(); i++) {
                System.out.println(found.get(i));
                System.out.println("номер "+(i+1));
                System.out.println("**************************************************");
            }
            System.out.println("Аккаунт с каким конкретно номером интересует?");
            int number = Integer.parseInt(inputData.input());
            if (number > 0 && number <= found.size()){
                return found.get(number-1);
            }
            else {
                return null;
            }
        }
        }
    }

    void showAll() {
        if (people.size() == 0) {
            System.out.println("Список пуст :(");
        } else {
            people.forEach(System.out::println);
        }
    }
}

