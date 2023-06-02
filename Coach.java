public class Coach extends Cart {
    
    final int numberOfChairs;
    final int internetAccses; // (0 = no access, 1 = access)

    public Coach(int ID, int numberOfChairs, int internetAccses) {

        super(ID,0);
        this.numberOfChairs = numberOfChairs;
        this.internetAccses = internetAccses;
    }


    public int getNumberOfChairs() {

        return this.numberOfChairs;
    }

    public int getInternetAccses() {
        
        return this.internetAccses;
    }
}
