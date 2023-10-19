package EMotorcyclesRentalSystem.model;

import EMotorcyclesRentalSystem.enums.MotorcycleType;


public class SmallMotorcycle extends ElectricMotorcycle{
    private static final double SmallBatteryCapacity = 50;
    private static final double energyConsumptionRate = 1;

    public SmallMotorcycle(RegistrationNumber registrationNumber){
        super(registrationNumber, SmallBatteryCapacity);
    }

    @Override
    public MotorcycleType getType() {
        // TODO Auto-generated method stub
       return MotorcycleType.SMALL;
    }

    @Override
    protected double getRequiredCharge(double kilometers) {
        // return the required charge for the ride
        return kilometers * energyConsumptionRate;
    }
}
