public class SleepingCar extends Cart {
    
    final int numberOfBeds;


    public SleepingCar(int ID, int numberOfBeds) {

        super(ID, 1);
        
        this.numberOfBeds = numberOfBeds;
    }


    public int getNumberOfBeds() {
        
        return this.numberOfBeds;
    }


}
