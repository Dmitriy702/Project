package Creator;

import Data.Address;
import Enum.Messages;
import Util.InputData;

import java.util.HashSet;

public class AddressCreator
{
    private final InputData inputData = new InputData();
    private final HashSet<Address> addresses = new HashSet<>();


    private String city()
    {
        String city;

        do
        {
            System.out.println("Введите город. Не более 20 символов.");
            city = inputData.input();
            if (!city.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"))
            {
                System.out.println(Messages.CITY_EXCEPTION);
            }
        } while (!city.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"));
        return city;
    }

    private String street()
    {
        String street;

        do
        {
            System.out.println("Введите улицу. Не более 20 символов.");
            street = inputData.input();
            if (!street.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"))
            {
                System.out.println(Messages.STREET_EXCEPTION);
            }
        } while (!street.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"));
        return street;
    }

    private String house()
    {
        String house;

        do
        {
            System.out.println("Введите номер дома. Корпус, если есть, указывать через /");
            house = inputData.input();
            if (!house.matches("^[1-9][0-9]{0,3}([a-zA-Z]|[а-яА-Я]|(/[1-9][0-9]?))?$"))
            {
                System.out.println(Messages.HOUSE_EXCEPTION);
            }
        } while (!house.matches("^[1-9][0-9]{0,3}([a-zA-Z]|[а-яА-Я]|(/[1-9][0-9]?))?$"));
        return house;
    }

    private String apartment()
    {
        String apartment;

        do
        {
            System.out.println("Введите номер квартиры");
            apartment = inputData.input();
            if (!apartment.matches("^[1-9][0-9]{0,3}([a-zA-Z]|[а-яА-Я])?$"))
            {
                System.out.println(Messages.APARTMENT_EXCEPTION);
            }
        } while (!apartment.matches("^[1-9][0-9]{0,3}([a-zA-Z]|[а-яА-Я])?$"));
        return apartment;
    }


    public HashSet<Address> createAddresses()
    {
        addresses.add(createAddress());
        String answer;
        System.out.println("Если хотите добавить новый адрес введите Y." + "\nЕсли хотите продолжить нажмите ввод");
        answer = inputData.input();
        while (answer.matches("[Yy]"))
        {
            addresses.add(createAddress());
            System.out.println("Если хотите добавить новый адрес введите Y." + "\nЕсли хотите продолжить нажмите ввод");
            answer = inputData.input();
        }

        return addresses;
    }

    private Address createAddress()
    {
        return new Address(country(), city(), street(), house(), apartment());
    }

    private String country()
    {
        String country;

        do
        {
            System.out.println("Введите страну. Не более 20 символов.");
            country = inputData.input();
            if (!country.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"))
            {
                System.out.println(Messages.COUNTRY_EXCEPTION);
            }
        } while (!country.matches("^([a-zA-Z]|[а-яА-Я]){1,20}$"));
        return country;
    }
}
