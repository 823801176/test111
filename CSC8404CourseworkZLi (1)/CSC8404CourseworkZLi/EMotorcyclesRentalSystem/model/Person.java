package EMotorcyclesRentalSystem.model;

import java.util.Date;
import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

    public Person(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new Date(dateOfBirth.getTime()); 
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime()); 
    }

    /**
     * Determines whether two Person objects are equal based on their first name, last name, and date of birth.
     * This method is overridden to provide a specific implementation for the Person class, ensuring that two
     * Person objects are considered equal if they have the same name and date of birth.
     *
     * @param o the object to be compared with the current object
     * @return true if the specified object is equal to the current object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
               lastName.equals(person.lastName) &&
               dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
