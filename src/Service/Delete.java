package Service;

import Data.People;
import Data.Person;
import Util.InputData;

import java.util.List;
import java.util.Set;

public class Delete {
    Set<Person> people = People.getInstance().getSet();
    InputData inputData = new InputData();
    void Remove(){
        System.out.println("""
                Введите фамилию удаляемого аккаунта или
                нажмите ввод что бы вернуться в меню""");
        String surname = inputData.input();
        if (surname.equals("")){
            return;
        }
        List<Person> found = people.stream().filter(person -> person.getSurname().equals(surname)).toList();
        if (found.size()==0)
        {
            System.out.println("Аккаунт с такой фамилией не найден!");
        }
        else if (found.size()==1){
            people.remove(found.get(0));
            People.getInstance().setSet(people);
            System.out.println("Аккаунт удалён.");
        }
        else {
            for (int i = 0; i<found.size(); i++) {
                System.out.println(found.get(i));
                System.out.println("**************************************************");
                System.out.println("номер "+(i+1));
            }
            System.out.println("Аккаунт с каким номером требуется удалить?");
            int number = Integer.parseInt(inputData.input());
            if (number > 0 && number <= found.size()) {
                people.remove(found.get(number - 1));
                System.out.println("Аккаунт удалён.");
            } else {
                System.out.println("Неверный номер!");
            }
        }
    }
}
