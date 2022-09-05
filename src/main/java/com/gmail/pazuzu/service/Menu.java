package com.gmail.pazuzu.service;

import com.gmail.pazuzu.util.KeyboardString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Menu
{
    private final PeopleManager peoplesManager;
    private final Demonstrator demonstrator;
    private final KeyboardString string;
    private final Statistic sexStatistic;
    private final Statistic ageStatistic;
    private final Statistic armyStatistic;

    public void showMenu()
    {
        String number;
        do
        {
            System.out.println("""
                    Введите цифру для выбора действия
                    1 - добавить аккаунт
                    2 - удаление аккаунта
                    3 - добавление в друзья
                    4 - просмотреть аккаунт
                    5 - посмотреть все аккаунты
                    6 - узнать сколько всего аккаунтов
                    7 - статистика по полам
                    8 - статистика по возрастным группам
                    9 - статистика для военкома =(
                    0 - закрыть программу""");
            number = string.input();
            switch (number)
            {
                /*
                    Смотри, всегда старайся мыслить критически.
                    Есть случаи, когда создание нового объекта это норм, а есть случаи когда нет.

                    Тут логика проста на самом деле.
                    Если объект у тебя стейтлес, т.е. не хранит каких-то данных в себе и по сути нужен не так часто и для выполнения какой-то логики,
                    то можно создавать каждый раз его.
                    Если объект в принципе используется часто или в цикле, то тут лучше сделать его более долгоживущим.

                    Если объект стейтфул, т.е. хранит в себе какое-то состояние, к которому надо время от времени обращаться из разных
                    мест программы, то объект надо реже создавать - один раз на всю программу или в рамках пользовательской сессии.

                    Если как в твоем случае есть какой-то манагер, то он по сути может и один побыть на прилагу
                    и можно его поиспользовать многократно. Также как и статистику.

                    Но можно и так оставить как ты сделал, но тогда расскажи почему так лучше
                 */
                case "1" -> peoplesManager.addNewAccount();
                case "2" -> peoplesManager.remove();
                case "3" -> peoplesManager.addFriends();
                case "4" -> demonstrator.showSingle();
                case "5" -> demonstrator.showAll();
                case "6" -> demonstrator.showAllCount();
                case "7" -> sexStatistic.showStatistic();
                case "8" -> ageStatistic.showStatistic();
                case "9" -> armyStatistic.showStatistic();
            }
        } while (!number.equals("0"));
        System.out.println("Ту-ру ту-ру ту, свись, всё!");
    }
}
