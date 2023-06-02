public class OpenFreight extends Cart{

    final int cargoCapacity; // in tonnes
    final int floorArea; // in square meters

    public OpenFreight(int ID, int cargoCapacity, int floorArea) {

        super(ID, 2);
        this.cargoCapacity = cargoCapacity;
        this.floorArea = floorArea;
    }


    public int getCargoCapacity() {

        return this.cargoCapacity;
    }

    public int getFloorArea() {
        
        return this.floorArea;
    }
     
}
