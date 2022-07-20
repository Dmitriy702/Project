package Service;

import Data.Person;

import java.util.Set;

public class AddFriends {
    Person you;
    Person friend;
    void addFriends(){
        System.out.println("Нужно найти ваш аккаунт");
        you = new Search().search();
        if (you==null){
            System.out.println("Аккаунт не найден!");
            return;
        }
        System.out.println("Нужно найти аккаунт вашего друга");
        friend = new Search().search();
        if (friend==null){
            System.out.println("Аккаунт не найден!");
            return;
        }
        if (you.equals(friend)){
            System.out.println("Нельзя иметь воображаемых друзей");
        }
        else {
            Set<Person> friends = you.getFriends();
            friends.add(friend);
            you.setFriends(friends);
            System.out.println("Друг добавлен");
        }

    }
}
