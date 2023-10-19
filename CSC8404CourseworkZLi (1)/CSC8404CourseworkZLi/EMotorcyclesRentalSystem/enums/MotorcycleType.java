package EMotorcyclesRentalSystem.enums;

public enum MotorcycleType {
    SMALL(50, 1),
    LARGE(75, 2);

    private final double batteryCapacity;
    private final double usagePerKillometer;

    MotorcycleType(double batteryCapacity, double usagePerKillometer) {
        this.batteryCapacity = batteryCapacity;
        this.usagePerKillometer = usagePerKillometer;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getUsagePerKillometer() {
        return usagePerKillometer;
    }
}
