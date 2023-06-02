public class DieselEngine extends Cart {

    final int maxSpeed; // in km/h
    final int fuelConsumption; // in liters/h

    public DieselEngine(int ID, int maxSpeed, int fuelConsumption) {

        super(ID, 5);
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    public int getMaxSpeed() {

        return this.maxSpeed;
    }

    public int getFuelConsumption() {
        
        return this.fuelConsumption;
    }
    
}
