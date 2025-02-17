package first_semester.lesson5.examples.compare;

public class ObjectsDataArray {
    private final Person[] array;
    private int nElems;

    public ObjectsDataArray(int size) {
        this.array = new Person[size];
        this.nElems = 0;
    }

    public boolean contains(Person searchPerson) {
        for (int i = 0; i < nElems; i++) {
            if (array[i].hashCode() == searchPerson.hashCode() && array[i].equals(searchPerson)) {
                return true;
            }
        }

        return false;
    }

    public boolean insert(Person person) {
        if (this.contains(person)) {
            return false;
        }

        array[nElems] = person;
        nElems++;
        return true;
    }

    public boolean delete(Person person) {
        int i;
        for (i = 0; i < this.nElems; i++) {
            if (array[i].hashCode() == person.hashCode() && array[i].equals(person)) {
                break;
            }
        }

        if (i == nElems - 1) {
            return false;
        } else {
            for (int j = i; j < nElems - 1; j++) {
                array[j] = array[j + 1];
            }
            nElems--;
            return true;
        }
    }

    public Person getOldest() {
        Person theOldestPerson = array[0];

        for (int i = 0; i < nElems; i++) {
            if (array[i].compareTo(theOldestPerson) > 0) {
                theOldestPerson = array[i];
            }
        }

        return theOldestPerson;
    }

    public Person getYoungest() {
        Person theYoungestPerson = array[0];

        for (int i = 0; i < nElems; i++) {
            if (array[i].compareTo(theYoungestPerson) < 0) {
                theYoungestPerson = array[i];
            }
        }

        return theYoungestPerson;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(array[i].toString());
        }
        System.out.println();
    }

    public int getSize() {
        return nElems;
    }
}
