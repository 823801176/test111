package EMotorcyclesRentalSystem.model;

import EMotorcyclesRentalSystem.enums.MotorcycleType;
import EMotorcyclesRentalSystem.exceptions.InsufficientChargeException;
import EMotorcyclesRentalSystem.utils.DateUtils;
import EMotorcyclesRentalSystem.exceptions.MotorcycleNotRentException;
import EMotorcyclesRentalSystem.model.*;

import java.util.HashMap;
import java.util.Map;

public class MotorcycleRentSystem {
    
    // Store the motorcycles in the system, key is the registration number, value is the motorcycle object.
    private Map<RegistrationNumber, ElectricMotorcycle> motorcycles = new HashMap<>();

    private Map<Person, ElectricMotorcycle> rentedMotorcycles = new HashMap<>();

    public int availableMotorcycles(MotorcycleType type){
        int count = 0;
        for (ElectricMotorcycle motorcycle : motorcycles.values()){
            if (motorcycle.getType() == type && !motorcycle.getIsRented()){
                count++;
            }
        }
        return count;
    }
    
    public Map<Person, ElectricMotorcycle> getRentedMotorcycles(){
        return rentedMotorcycles;
    }

    public ElectricMotorcycle getMotorcycle(Person person){
        return rentedMotorcycles.get(person);
    }

    public String issueMotorcycle(Person person, DrivingLicence drivingLicence, MotorcycleType type){
        // 检查是否已经租了一辆摩托车
        if(rentedMotorcycles.containsKey(person)){
            return "You have already rented a motorcycle.";
        }
    
        // 检查是否持有完整的驾照
        if(!drivingLicence.isFullLicence()){
            return "You don't have a full licence.";
        }
    
        int age = DateUtils.getAge(person.getDateOfBirth());
        int yearsSinceIssued = drivingLicence.getYearsSinceIssued();
    
        // 根据摩托车类型检查年龄和驾照持有的年数
        if (type == MotorcycleType.SMALL) {
            if (age < 20 || yearsSinceIssued < 1) {
                return "Cannot issue small motorcycle: Age or licence duration requirement not met.";
            }
        } else if (type == MotorcycleType.LARGE) {
            if (age < 25 || yearsSinceIssued < 5) {
                return "Cannot issue large motorcycle: Age or licence duration requirement not met.";
            }
        }
        return "No motorcycle available.";
    }

    public double terminalRental(Person person) throws MotorcycleNotRentException{
        ElectricMotorcycle rentedMotorcycle = rentedMotorcycles.get(person);

        if(rentedMotorcycle == null){
            throw new MotorcycleNotRentException("You have not rented a motorcycle.");
        }

        double requiredCharge = rentedMotorcycle.getBatteryCapacity() - rentedMotorcycle.getBatteryCharged();
        
        rentedMotorcycles.remove(person);
        rentedMotorcycle.returnMotorcycle();

        return requiredCharge;
    }
}

