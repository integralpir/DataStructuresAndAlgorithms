package first_semester.lesson5.examples.compare;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String passportSeriesNumber;
    private byte age;

    public Person(String firstName, String lastName, String passportSeriesNumber, byte age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportSeriesNumber = passportSeriesNumber;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportSeriesNumber() {
        return passportSeriesNumber;
    }

    public void setPassportSeriesNumber(String passportSeriesNumber) {
        this.passportSeriesNumber = passportSeriesNumber;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(passportSeriesNumber, person.passportSeriesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passportSeriesNumber, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportSeriesNumber='" + passportSeriesNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
