public class ElectricalEngine extends Cart {

    final int maxSpeed; // in km/h
    final int power; // in kW

    public ElectricalEngine(int ID, int maxSpeed, int power) {

        super(ID, 4);
        this.maxSpeed = maxSpeed;
        this.power = power;
    }


    public int getMaxSpeed() {

        return this.maxSpeed;
    }

    public int getPower() {
        
        return this.power;
    }
    
}
