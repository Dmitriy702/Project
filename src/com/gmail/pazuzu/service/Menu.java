package com.gmail.pazuzu.service;

import com.gmail.pazuzu.util.KeyboardLine;


public class Menu
{
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
                case "1" -> new PeoplesManager(line).addNewAccount();
                case "2" -> new PeoplesManager(line).remove();
                case "3" -> new PeoplesManager(line).addFriends();
                case "4" -> new Statistic().showSingle();
                case "5" -> new Statistic().showAll();
                case "6" -> new Statistic().showAllCount();
                case "7" -> new Statistic().showSexStatistic();
                case "8" -> new Statistic().showAgeStatistic();
                case "9" -> new Statistic().showArmyStatistic();
            }
        } while (!number.equals("0"));
        System.out.println("Ту-ру ту-ру ту, свись, всё!");
    }
}
