package EMotorcyclesRentalSystem.tests;

import EMotorcyclesRentalSystem.model.ElectricMotorcycle;
import EMotorcyclesRentalSystem.model.SmallMotorcycle;
import EMotorcyclesRentalSystem.model.RegistrationNumber;
import EMotorcyclesRentalSystem.utils.RegistrationNumberGenerator;
import EMotorcyclesRentalSystem.exceptions.InsufficientChargeException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricMotorcycleTest {
    private SmallMotorcycle smallMotorCycle;
    private RegistrationNumber registrationNumber;
    private final double fullChargedBattary = 50;

    @Before
    public void setUp(){
        RegistrationNumber registrationNumber = RegistrationNumberGenerator.generateRegistrationNumber();
        smallMotorCycle = new SmallMotorcycle(registrationNumber);
    }

    @Test
    public void testGetBatteryCapacity(){
        assertEquals(fullChargedBattary, smallMotorCycle.getBatteryCapacity(), 0.01);
    }

    @Test
    public void testGetBartteryCharge(){
        double fullChargedBattary = 50;
        assertEquals(fullChargedBattary, smallMotorCycle.getBatteryCharged(), 0.01);
    }

    @Test
    public void testRide() throws InsufficientChargeException{
        double distanceRided = 10.0;
        double chargeUsed = 10.0;
        double chargeLeft = fullChargedBattary - chargeUsed;

        smallMotorCycle.ride(distanceRided);

        assertEquals(chargeLeft, smallMotorCycle.getBatteryCharged(), 0.01);
    }

    @Test(expected = InsufficientChargeException.class)
    public void testRideWithInsufficientCharge() throws InsufficientChargeException{
        double distanceRided = 52.0;
        smallMotorCycle.ride(distanceRided);
    }

    @Test
    public void testRentReturn(){
        assertFalse(smallMotorCycle.getIsRented());
        smallMotorCycle.rent();
        assertTrue(smallMotorCycle.getIsRented());
        smallMotorCycle.returnMotorcycle();
        assertFalse(smallMotorCycle.getIsRented());
    }
}
