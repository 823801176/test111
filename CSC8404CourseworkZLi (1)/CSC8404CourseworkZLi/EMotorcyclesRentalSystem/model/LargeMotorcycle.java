package EMotorcyclesRentalSystem.model;

import EMotorcyclesRentalSystem.enums.MotorcycleType;

public class LargeMotorcycle extends ElectricMotorcycle{
        private static final double LargeBatteryCapacity = 75;
    private static final double energyConsumptionRate = 2;

    public LargeMotorcycle(RegistrationNumber registrationNumber){
        super(registrationNumber, LargeBatteryCapacity);
    }


    @Override
    public MotorcycleType getType() {
        // TODO Auto-generated method stub
       return MotorcycleType.LARGE;
    }

    @Override
    protected double getRequiredCharge(double kilometers) {
        // return the required charge for the ride
        return kilometers * energyConsumptionRate;
    }
}
