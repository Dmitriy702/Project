package Creator;
import Enum.Messages;
import Data.Contact;
import Util.InputData;

import java.util.HashSet;

public class ContactCreator {

    private final InputData inputData = new InputData();
    private String temp;

    private String telNumberNecessarily() {
        do {
            System.out.println("""
                    Введите 9 цифр номера телефона в формате:
                    17ХХХХХХХ, 25ХХХХХХХ, 29ХХХХХХХ, 33ХХХХХХХ, 44ХХХХХХХ.""");
            temp = inputData.input();
            if (!temp.matches("^(17|25|29|33|44)[0-9]{7}$")) {
                System.out.println(Messages.TEL_NUMBER_EXCEPTION);
            }
        }
        while (!temp.matches("^(17|25|29|33|44)[0-9]{7}$"));
        return temp;
    }

    private String telNumber() {
        do {
            System.out.println("""
                    Если желаете добавить ещё один номер то,
                    введите 9 цифр номера телефона в формате:
                    17ХХХХХХХ, 25ХХХХХХХ, 29ХХХХХХХ, 33ХХХХХХХ, 44ХХХХХХХ.
                    Или нажмите ввод""");
            temp = inputData.input();
            if (!temp.matches("(^$)|(^(17|25|29|33|44)[0-9]{7}$)")) {
                System.out.println(Messages.TEL_NUMBER_EXCEPTION);
            }
        }
        while (!temp.matches("(^$)|(^(17|25|29|33|44)[0-9]{7}$)"));
        return temp;
    }

    private String eMail() {
        do {
            System.out.println("""
                    Если желаете, ведите eMail, что бы добавить его в свои контакты,
                    или нажмите ввод чтобы продолжить""");
            temp = inputData.input();
            if (!temp.matches("(^$)|(^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$)")) {
                System.out.println(Messages.EMAIL_EXCEPTION);
            }
        }
        while (!temp.matches("(^$)|(^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$)"));
        return temp;
    }

    public Contact createContact() {
        boolean notSkippedNumber = true;
        boolean notSkippedEMail = true;
        Contact contact = new Contact();
        HashSet <String> numbers = new HashSet<>();
        numbers.add(telNumberNecessarily());
        do {
            String number = telNumber();
            if (number.length() > 0) {
               numbers.add(number);
            } else {
                notSkippedNumber = false;
            }
        }
        while (notSkippedNumber);
        contact.setTelNumbers(numbers);
        HashSet <String> eMails = new HashSet<>();
        do {
            String eMail = eMail();
            if (eMail.length() > 0) {
               eMails.add(eMail);
            } else {
                notSkippedEMail = false;
            }
        }
        while (notSkippedEMail);
        contact.setMails(eMails);
        return contact;
    }
}
