package EMotorcyclesRentalSystem.utils;

import EMotorcyclesRentalSystem.model.DrivingLicence;
import EMotorcyclesRentalSystem.model.Person;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class LicenceNumberGenerator {

    private static final Set<String> existingLicenceNumbers = new HashSet<>();
    private static final Random rand = new Random();

    public static String generateLicenceNumber(Person person, int yearOfIssue) {
        String initials = person.getFirstName().substring(0, 1) + person.getLastName().substring(0, 1);
        String year = String.valueOf(yearOfIssue);
        String licenceNumber;
        
        do {
            int serialNumber = rand.nextInt(99) + 1;
            licenceNumber = initials + "-" + year + "-" + String.format("%02d", serialNumber);
        } while (existingLicenceNumbers.contains(licenceNumber));

        existingLicenceNumbers.add(licenceNumber);
        return licenceNumber;
    }
}
