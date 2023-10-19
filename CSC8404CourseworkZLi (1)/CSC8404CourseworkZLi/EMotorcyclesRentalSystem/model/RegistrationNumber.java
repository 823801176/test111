package EMotorcyclesRentalSystem.model;

import java.util.HashSet;
import java.util.Set;

public class RegistrationNumber {

    private static final Set<String> existingNumbers = new HashSet<>();

    private final String firstComponent; 
    private final String secondComponent; 

    public RegistrationNumber(String firstComponent, String secondComponent) {
        if (existingNumbers.contains(firstComponent + " " + secondComponent)) {
            throw new IllegalArgumentException("The registration number already exists.");
        }
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
        existingNumbers.add(toString());
    }

    public String getFirstComponent() {
        return firstComponent;
    }

    public String getSecondComponent() {
        return secondComponent;
    }

    @Override
    public String toString() {
        return firstComponent + " " + secondComponent;
    }

    public static boolean isNumberExisting(String number) {
        return existingNumbers.contains(number);
    }
}