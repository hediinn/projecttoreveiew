public abstract class Cart {
    // all carts have types and ID's
    final int type;
    final int ID;

    public Cart(int ID, int type) {

    	this.ID = ID;
        this.type = type;
    }  

    public int getType() {

        return this.type;
    }

    public int getID() {
        
        return this.ID;
    }
}
