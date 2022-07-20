package Service;

import Data.People;

public class CountAllPeople {
    public void all(){
        People people = People.getInstance();
        System.out.println(people.getSet().size());
    }
}
