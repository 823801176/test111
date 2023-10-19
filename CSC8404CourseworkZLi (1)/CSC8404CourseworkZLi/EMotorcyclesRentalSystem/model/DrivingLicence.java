package EMotorcyclesRentalSystem.model;
/**
 * 
 */
import java.util.Calendar;
import java.util.Date;

import EMotorcyclesRentalSystem.utils.DateUtils;

public class DrivingLicence {
    private final LicenceNumber licenceNumber;
    private final Date dateOfIssue;
    private final boolean isFullLicence;

    /**
     * 
     *  */
    public DrivingLicence(Person person, Date dateOfIssue, boolean isFullLicence) {
        this.licenceNumber = LicenceNumber.generateLicenceNumber(person, dateOfIssue);
        this.dateOfIssue = new Date(dateOfIssue.getTime()); // Defensive copy
        this.isFullLicence = isFullLicence;
    }

    public String getLicenceNumber() {
        return licenceNumber.toString();
    }

    public Date getDateOfIssue() {
        return new Date(dateOfIssue.getTime()); // Defensive copy
    }

    public boolean isFullLicence() {
        return isFullLicence;
    }

    public int getYearsSinceIssued() {
            Calendar issueCalendar = Calendar.getInstance();
            issueCalendar.setTime(this.dateOfIssue);
            int issueYear = issueCalendar.get(Calendar.YEAR);
        
            Calendar currentCalendar = Calendar.getInstance();
            int currentYear = currentCalendar.get(Calendar.YEAR);
        
            return currentYear - issueYear;
    }
        
    private static class LicenceNumber {
        private final String initials;
        private final int yearOfIssue;
        private final int serialNumber;

        private static int serialNumberCounter = 0;
        private static final Object lock = new Object();

        private LicenceNumber(String initials, int yearOfIssue, int serialNumber) {
            this.initials = initials;
            this.yearOfIssue = yearOfIssue;
            this.serialNumber = serialNumber;
        }

        public static LicenceNumber generateLicenceNumber(Person person, Date dateOfIssue) {
            String initials = person.getFirstName().substring(0, 1) + person.getLastName().substring(0, 1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOfIssue);
            int yearOfIssue = calendar.get(Calendar.YEAR);
            int serialNumber;
            synchronized (lock) {
                serialNumber = ++serialNumberCounter;
            }
            return new LicenceNumber(initials, yearOfIssue, serialNumber);
        }


        @Override
        public String toString() {
            return initials + "-" + yearOfIssue + "-" + serialNumber;
        }
    }
}
