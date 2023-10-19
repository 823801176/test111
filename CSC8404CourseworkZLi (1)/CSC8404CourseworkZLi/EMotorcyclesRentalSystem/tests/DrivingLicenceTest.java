package EMotorcyclesRentalSystem.tests;

import EMotorcyclesRentalSystem.model.Person;
import EMotorcyclesRentalSystem.utils.LicenceNumberGenerator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;


public class DrivingLicenceTest {

    private Person person1;
    private Person person2;

    @Before
    public void setUp() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1999, Calendar.JULY, 12);
        person1 = new Person("Zipeng", "Li", calendar1.getTime());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1962, Calendar.JUNE, 3);
        person2 = new Person("Lingjun", "Li", calendar2.getTime());
    }

    @Test
    public void testLicenceNumberGenerator() {
        String licenceNumber1 = LicenceNumberGenerator.generateLicenceNumber(person1, 2018);
        String licenceNumber2 = LicenceNumberGenerator.generateLicenceNumber(person2, 1990);

        assertTrue(licenceNumber1.matches("[A-Z]{2}-\\d{4}-\\d{2}"));
        assertTrue(licenceNumber2.matches("[A-Z]{2}-\\d{4}-\\d{2}"));
    }
}