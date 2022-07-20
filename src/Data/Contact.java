package Data;

import java.util.Objects;
import java.util.Set;

public class Contact {
    Set<String> telNumbers;
    Set<String> eMails;


    public void setTelNumbers(Set<String> telNumbers) {
        this.telNumbers = telNumbers;
    }


    public void setMails(Set<String> eMails) {
        this.eMails = eMails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(telNumbers, contact.telNumbers) && Objects.equals(eMails, contact.eMails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telNumbers, eMails);
    }

    @Override
    public String toString() {
        return "\ntelNumbers=" + telNumbers +
               "\neMails=" + eMails;
    }
}
