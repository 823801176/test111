package EMotorcyclesRentalSystem.model;

import java.util.Calendar;
import java.util.Random;

public class LicenceNumber {
    
    private final String initials;
    private final int yearOfIssue;
    private final String serialNumber;
    private static final Random rand = new Random();

    public LicenceNumber(String initials, int yearOfIssue, String serialNumber) {
        this.initials = initials;
        this.yearOfIssue = yearOfIssue;
        this.serialNumber = serialNumber;
    }

    public static LicenceNumber generateLicenceNumber(String firstName, String lastName, int yearOfIssue) {
        String initials = String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0));
        int serialNumber = rand.nextInt(99) + 1;
        String newSerialNumber = String.format("%02d", serialNumber);
        return new LicenceNumber(initials, yearOfIssue, newSerialNumber);
    }

    public static LicenceNumber generateLicenceNumber(String firstName, String lastName) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return generateLicenceNumber(firstName, lastName, currentYear);
    }

    @Override
    public String toString() {
        return initials + "-" + yearOfIssue + "-" + serialNumber;
    }

    public String getInitials() {
        return initials;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getUniqueSerialNumber() {
        return serialNumber;
    }
}
