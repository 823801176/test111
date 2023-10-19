package EMotorcyclesRentalSystem.tests;

import EMotorcyclesRentalSystem.model.*;
import EMotorcyclesRentalSystem.utils.DateUtils;
import EMotorcyclesRentalSystem.utils.RegistrationNumberGenerator;
import EMotorcyclesRentalSystem.enums.MotorcycleType;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class test {

    public static void main(String[] args) {
        // create a date of birth
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.JULY, 12);
        Date testDateOfBirth = calendar.getTime();

        // use the date to create a person object
        Person person = new Person("Zipeng", "Li", testDateOfBirth);
        System.out.println("Person Details:");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Date of Birth: " + person.getDateOfBirth());
        System.out.println("-------------------------");

        // Create a driving licence object
        DrivingLicence drivingLicence = new DrivingLicence(person, DateUtils.getCurrentDate(), true);
        System.out.println("Driving Licence Details:");
        System.out.println("Licence Number: " + drivingLicence.getLicenceNumber());
        System.out.println("Date of Issue: " + drivingLicence.getDateOfIssue());
        System.out.println("Is Full Licence: " + drivingLicence.isFullLicence());
        System.out.println("-------------------------");

        SmallMotorcycle[] smallMotorcycles = new SmallMotorcycle[5];
        for (int i = 0; i<5; i++){
            smallMotorcycles[i] = new SmallMotorcycle(RegistrationNumberGenerator.generateRegistrationNumber());  
        }
        System.out.println("-------------------------");

        LargeMotorcycle[] largeMotorcycles = new LargeMotorcycle[5];
        for (int i = 0; i<5; i++){
            RegistrationNumber registrationNumber = RegistrationNumberGenerator.generateRegistrationNumber();
            LargeMotorcycle LargeMotorcycle = new LargeMotorcycle(registrationNumber);
            System.out.println("Large Motorcycle Details:" + registrationNumber);
        }
        System.out.println("-------------------------");

        Random random = new Random();
        int randomIndex = random.nextInt(5);
        SmallMotorcycle testSmallMotorcycle = smallMotorcycles[randomIndex];
        System.out.println("Initial battery charge: " + testSmallMotorcycle.getBatteryCharged() + " kWh");


    }
}
