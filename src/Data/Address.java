package Data;

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
