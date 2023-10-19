package EMotorcyclesRentalSystem.tests;

import EMotorcyclesRentalSystem.model.Person;
import EMotorcyclesRentalSystem.utils.DateUtils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Calendar;


public class PersonTest {
    private Person person;

    @Before
    public void setUp(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.JULY, 12);
        person = new Person("Zipeng", "Li", calendar.getTime());
    }

    @Test
    public void testGetFirstName(){
        assertEquals("Zipeng", person.getFirstName());
    }

    @Test
    public void testGetLastName(){
        assertEquals("Li", person.getLastName());
    }

    @Test
    public void testGetDateOfBirth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.JULY, 12);
        assertEquals(calendar.getTime(), person.getDateOfBirth());
    }
}
