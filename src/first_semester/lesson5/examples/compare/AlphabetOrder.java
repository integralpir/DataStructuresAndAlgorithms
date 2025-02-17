package first_semester.lesson5.examples.compare;

import java.util.Comparator;

public class AlphabetOrder implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
