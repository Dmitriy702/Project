package Service;

import Util.InputData;


public class Menu {
    InputData inputData = new InputData();
    public void menu() {
        String number;
        do {
            System.out.println("""
                    Введите цифру для выбора действия
                    1 - добавить аккаунт
                    2 - просмотр аккаунта(ов) по фамилии
                    3 - удаление аккаунта по фамилии
                    4 - добавление в друзья
                    5 - узнать сколько всего аккаунтов
                    6 - посмотреть все аккаунты
                    7 - закрыть программу""");
            number = inputData.input();
            switch (number) {
                case "1" -> new AddPerson().add();
                case "2" -> new Search().show();
                case "3" -> new Delete().Remove();
                case "4" -> new AddFriends().addFriends();
                case "5" -> new CountAllPeople().all();
                case "6" -> new Search().showAll();
            }
        } while (!number.equals("7"));
        System.out.println("Ту-ру ту-ру ту, свись, всё!");
    }
}
