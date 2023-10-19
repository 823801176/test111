package EMotorcyclesRentalSystem.utils;

import EMotorcyclesRentalSystem.model.RegistrationNumber;

import java.util.Random;

public class RegistrationNumberGenerator{
    private static final Random random = new Random();

    public static RegistrationNumber generateRegistrationNumber(){
        String firstComponent;
        String secondComponent;
        do {
            firstComponent = generateTwoLetters() + generateTwoDigits();
            secondComponent = generateThreeLetters();
        } while (RegistrationNumber.isNumberExisting(firstComponent + " " + secondComponent));
        
        return new RegistrationNumber(firstComponent, secondComponent);
    }

    private static String generateTwoLetters() {
        return (char) ('A' + random.nextInt(26)) + "" + (char) ('A' + random.nextInt(26));
    }

    private static String generateTwoDigits() {
        return String.format("%02d", random.nextInt(100));
    }

    private static String generateThreeLetters() {
        return (char) ('A' + random.nextInt(26)) + "" + 
               (char) ('A' + random.nextInt(26)) + "" + 
               (char) ('A' + random.nextInt(26));
    }

}
    
