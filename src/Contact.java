import java.util.Objects;

public class Contact {
    private String telNumber;
    private String eMail;

    public Contact(String telNumber, String eMail) {
        this.telNumber = telNumber;
        this.eMail = eMail;
    }

    public Contact(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(telNumber, contact.telNumber) && Objects.equals(eMail, contact.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telNumber, eMail);
    }

    @Override
    public String toString() {
        if (eMail==null){
            return "telNumber - " + telNumber;
        }
        else {
            return "telNumber - " + telNumber + ", eMail : " + eMail;
        }
    }
    private static String telNumber() {
        System.out.println("Введите 9 цифр номера телефона в формате:" +
                "\n17ХХХХХХХ, 25ХХХХХХХ, 29ХХХХХХХ, 33ХХХХХХХ, 44ХХХХХХХ.");
        try {
            return InputData.input("^(17|25|29|33|44)[0-9]{7}$",Messages.TEL_NUMBER_EXCEPTION);
        }
        catch (InputException exception){
            System.out.println(Messages.TEL_NUMBER_EXCEPTION);
            return telNumber();
        }
    }
    private static String eMail() {
        System.out.println("Введите eMail или нажмите ввод чтобы пропустить шаг");
        try {
            return InputData.input("(^$)|(^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$)",Messages.EMAIL_EXCEPTION);
        }
        catch (InputException exception){
            System.out.println(Messages.EMAIL_EXCEPTION);
            return eMail();
        }
    }
    public static Contact createContact(){
        String email = eMail();
        if (email.length()==0){
            return new Contact(telNumber());
        }
        else {
            return new Contact(telNumber(),email);
        }
    }
}
