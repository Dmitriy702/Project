package com.gmail.pazuzu.service;

import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.makequestion.AskYesOrNot;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import com.gmail.pazuzu.util.KeyboardLine;


public class Menu
{
    /*
        почему не приватное?
        что за линия?
     */
    KeyboardLine line = new KeyboardLine();



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
            number = line.input();
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
                case "2" -> new PeoplesManager(line).remove();
                case "3" -> new PeoplesManager(line).addFriends();
                case "4" -> statistic.showSingle(); // почему статистика ищет и показывает одного чела? в чем статистика?
                case "5" -> new Statistic().showAll(); // почему статистика показывает всех людей? в чем статистика?
                case "6" -> new Statistic().showAllCount(); // Показать все количество чего?
                case "7" -> new Statistic().showSexStatistic();
                case "8" -> new Statistic().showAgeStatistic();
                case "9" -> new Statistic().showArmyStatistic();
            }
        } while (!number.equals("0"));
        System.out.println("Ту-ру ту-ру ту, свись, всё!");
    }
}
