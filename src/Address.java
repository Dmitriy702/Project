import java.util.Objects;

public class Address
{
    private final String county;
    private final String city;
    private final String street;
    private final String house;
    private final String apartment;

    public Address(String county, String city, String street, String house, String apartment)
    {
        this.county = county;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    private static String country()
    {
        System.out.println("Введите страну. Не более 20 символов");
        try
        {
            return InputData.input("^([a-zA-Z]|[а-яА-Я]){1,20}$", Messages.COUNTRY_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.COUNTRY_EXCEPTION);
            return country();
        }
    }

    private static String city()
    {
        System.out.println("Введите город. Не более 20 символов");
        try
        {
            return InputData.input("^([a-zA-Z]|[а-яА-Я]){1,20}$", Messages.CITY_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.CITY_EXCEPTION);
            return city();
        }
    }

    private static String street()
    {
        System.out.println("Введите улицу. Не более 20 символов");
        try
        {
            return InputData.input("^([a-zA-Z]|[а-яА-Я]){1,20}$", Messages.STREET_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.STREET_EXCEPTION);
            return street();
        }
    }

    private static String house()
    {
        System.out.println("Введите номер дома. Корпус, если есть, указывать через /");
        try
        {
            return InputData.input("^[1-9][0-9]{0,3}([a-zA-Z]|[а-яА-Я]|(\\/[1-9][0-9]{0,1}))?$", Messages.HOUSE_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.HOUSE_EXCEPTION);
            return house();
        }
    }

    private static String apartment()
    {
        System.out.println("Введите номер квартиры");
        try
        {
            return InputData.input("^[1-9][0-9]{0,3}([a-zA-Z]|[а-яА-Я])?$", Messages.APARTMENT_EXCEPTION);
        }
        catch (InputException exception)
        {
            System.out.println(Messages.APARTMENT_EXCEPTION);
            return apartment();
        }
    }

    public static Address createAddress()
    {
        return new Address(country(), city(), street(), house(), apartment());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Address address = (Address) o;
        return house.equals(address.house) && apartment.equals(address.apartment) && county.equals(address.county) && city.equals(address.city) && street.equals(address.street);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(county, city, street, house, apartment);
    }

    @Override
    public String toString()
    {
        return "county " + county + ", city " + city + ", street " + street + ", house " + house + ", apartment " + apartment;
    }

}
