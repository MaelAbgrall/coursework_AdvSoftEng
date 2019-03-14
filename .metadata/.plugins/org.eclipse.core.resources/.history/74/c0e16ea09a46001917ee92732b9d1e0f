package models;

/**
 * @author Ahmed ALJeferi
 *
 */

public class Drink extends Item {

    private boolean alcohol = false;

    /**
     * Create a drink object and add it to the MENUCOUNTER. This constructor should be called when creating a object from a file (ID already known)
     * 
     * Attributes: id String, name String, price Double, description String, alcohol Boolean
     */
    public Drink(String id, String name, Double price, String description, boolean alcohol) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.alcohol = alcohol;

        MENUCOUNTER.add(id);
    }

    /**
     * Create a drink object and add it to the MENUCOUNTER. this constructor
     * should be called when creating objects from program
     * 
     * Attributes: name String
     */
    public Drink(String name) {
        this.name = name;

        this.createID();
        MENUCOUNTER.add(this.id);
    }


    /**
     * Create the ID using the MENUCOUNTER size and the prefix DR
     */
    @Override
    protected void createID() {
        this.id = "DR" + MENUCOUNTER.size();
    }

    @Override
    public String getLine() {
        String line = this.id + "," + this.name + "," + this.price + "," + this.description + "," + this.alcohol;
        return line;
    }

}
