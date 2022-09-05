package com.gmail.pazuzu.data;

import lombok.Data;

import java.util.Set;

@Data
public class Contact
{
    private Set<String> telNumbers;
    private Set<String> eMails;

    //    public Set<String> getTelNumbers()
    //    {
    //        return telNumbers;
    //    }
    //
    //    public void setTelNumbers(Set<String> telNumbers)
    //    {
    //        this.telNumbers = telNumbers;
    //    }
    //
    //    public void setMails(Set<String> eMails)
    //    {
    //        this.eMails = eMails;
    //    }
    //
    //    @Override
    //    public boolean equals(Object o)
    //    {
    //        if (this == o)
    //        {
    //            return true;
    //        }
    //        if (o == null || getClass() != o.getClass())
    //        {
    //            return false;
    //        }
    //        Contact contact = (Contact) o;
    //        return Objects.equals(telNumbers, contact.telNumbers) && Objects.equals(eMails, contact.eMails);
    //    }
    //
    //    @Override
    //    public int hashCode()
    //    {
    //        return Objects.hash(telNumbers, eMails);
    //    }
    //
    //    @Override
    //    public String toString()
    //    {
    //        return "\ntelNumbers=" + telNumbers + "\neMails=" + eMails;
    //    }
}
