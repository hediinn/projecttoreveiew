public class CoveredFreight extends Cart {
    
    final int cargoCapacity; // in cubic meters

    public CoveredFreight(int ID, int cargoCapacity) {

        super(ID, 3);
        this.cargoCapacity = cargoCapacity;
    }


    public int getCargoCapacity() {
        
        return this.cargoCapacity;
    }

}
