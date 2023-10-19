package EMotorcyclesRentalSystem.model;

import EMotorcyclesRentalSystem.enums.MotorcycleType;
import EMotorcyclesRentalSystem.exceptions.InsufficientChargeException;

public abstract class ElectricMotorcycle{
    private final RegistrationNumber registrationNumber;
    private double batteryCharge;
    private final double batteryCapacity;
    private boolean isRented;

    public ElectricMotorcycle(RegistrationNumber registrationNumber,double batteryCapacity){
        this.registrationNumber = registrationNumber;
        this.batteryCapacity = batteryCapacity;
        // Assume the motorcycle start with fully charged.
        this.batteryCharge = batteryCapacity;
        this.isRented = false;
    }

    public RegistrationNumber getRegistrationNumber(){
        return registrationNumber;
    }

    public double getBatteryCapacity(){
        return batteryCapacity;
    }

    public double getBatteryCharged(){
        return batteryCharge;
    }

    public boolean getIsRented(){
        return isRented;
    }

    public void rent(){
        if(isRented){
            throw new IllegalStateException("This E-motorcycle is already rented.");
        }
        isRented = true;
    }

    public void returnMotorcycle(){
        if(!isRented){
            throw new IllegalStateException("This E-motorcycle is not rented.");
        }
        isRented = false;
    }

    public abstract MotorcycleType getType();

    public double ride(double kilometers) throws InsufficientChargeException{
        double requiredCharge = getRequiredCharge(kilometers);
        if (requiredCharge > batteryCharge) {
            throw new InsufficientChargeException("The battery charge is not enough for this ride.");
        }
        batteryCharge -= requiredCharge;
        return requiredCharge;
    }

    protected void reduceBatteryCharge(double amount) {
        this.batteryCharge -= amount;
    }
    
    protected abstract double getRequiredCharge(double kilometers);
}