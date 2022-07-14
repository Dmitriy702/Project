

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PeopleFactory {
    private static HashSet<Person> set = new HashSet<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        menu();
    }

    private static void menu() throws ParseException {
        System.out.println("Введите цифру для выбора действия" +
                "\n1 - добавить уинкальный аккаунт" +
                "\n2 - просмотр аккаунта(ов) по фамилии или всего списка (нужно что бы узнать id)" +
                "\n3 - удаление аккаунта по id" +
                "\n4 - добавление в друзья (нужны id аккаунтов)" +
                "\n5 - закрыть программу");
        switch (scanner.nextLine()){
            case "1" -> {
                set.add(Person.createPerson());
                menu();
            }
            case "2" -> {
                search();
                menu();
            }
            case "3" -> {
                deletePerson();
                menu();
            }
            case "4" -> {
                makeFriends();
                menu();
            }
            case "5" -> {
                System.out.println("Пока!");
                return;
            }
            default -> menu();
        }
    }

    private static void makeFriends() throws ParseException {
        int idAcc=0;
        int idFri=0;
        System.out.println("Введите id аккаунт (кому добавить друга)," +
                "\nили нажите ввод чтоб веруться в меню");
        try {
             idAcc = idChek();
        }catch (InputException e){
            System.out.println(Messages.ID_EXCEPTION);
            makeFriends();
        }
        if (idAcc==0){
            return;
        }
        System.out.println("Введите id друга," +
                "\nили нажите ввод чтоб веруться в меню");
        try {
             idFri = idChek();
        }catch (InputException e){
            System.out.println(Messages.ID_EXCEPTION);
            makeFriends();
        }
        if (idFri==0){
            return;
        }
        Person acc=null;
        Person fri=null;
        for (Person p :set) {
            if (idAcc== p.getId()){
                acc = p;
            }
            if (idFri== p.getId()){
                fri=p;
            }
        }
        if (acc != null && fri != null){
            acc.addFriends(fri);
        }
        else {
            System.out.println("Какой то аккаунт не найден!");
        }
    }

    private static void deletePerson() throws ParseException {
        System.out.println("Введите id удаляемого аккаунта" +
                "\nили нажмите ввод что бы вернуться в меню");
        int id = 0;
        try {
            id = idChek();
        }
        catch (InputException e){
            System.out.println(Messages.ID_EXCEPTION);
            deletePerson();
        }
        if (id==0){
            return;
        }
        Iterator<Person> iterator = set.iterator();
        boolean flag=true;
        while (iterator.hasNext()){
            if (iterator.next().getId()==id){
                iterator.remove();
                flag=false;

            }
        }
        if (flag){
            System.out.println("Элемент с таким индексом не найден");
        }
    }

    private static void search() throws ParseException {
        System.out.println("Введите фамилию или нажмите ввод чтобы посмотреть весь список");
        String answer = scanner.nextLine();
        if (answer.matches("^$")&&set.size()>0){
            for (Person p :set) {
                System.out.println(p);
            }
        }
        else if (set.size()==0){
            System.out.println("Коллекция пуста :(");
        }
        else {
            int counter = 0;
            for (Person p :set) {
                if (p.getSurname().equals(answer)){
                    System.out.println(p);
                    counter++;
                }
            }
            if (counter==0){
                System.out.println("Аккаунт с такой фамилией не найден!");
            }
        }
    }
    private static int idChek(){
        String s = scanner.nextLine();
        if (s.matches("[0-9]{1,16}|^$")){
            if (s.length()==0){
                return 0;
            }
            else {
                return Integer.parseInt(s);
            }
        }
        else {
            throw new InputException(Messages.ID_EXCEPTION);
        }
    }
}
