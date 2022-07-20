package Data;

import java.util.HashSet;
import java.util.Set;

public class People {
    private Set<Person> people;
    private static People INSTANCE;

    private People() {
        people = new HashSet<>();
    }

    public static People getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new People();
        }
        return INSTANCE;
    }

    public Set<Person> getSet() {
        return people;
    }

    public void setSet(Set<Person> people) {
        this.people = people;
    }
}
