package models;

/**
 * @author Ahmed ALJeferi
 *
 */
public class Dessert extends Item {

    /**
     * create a Dessert object and add it to the MENUCOUNTER. This constructor is
     * called when creating objects from a file, and ID are known
     * 
     * Attributes: id String, name String, price Double, description String
     */
    public Dessert(String id, String name, Double price, String description) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
        
        MENUCOUNTER.add(id);
    }

    /**
     * Create a dessert object and add it to the MENUCOUNTER. this constructor
     * should be called when creating objects from program
     * 
     * Attributes: name String
     */
    public Dessert(String name) {
        this.createID();

        this.name = name;
        MENUCOUNTER.add(this.id);
    }

    /**
     * generate an ID using DS + the size of the MENUCOUNTER
     */
    @Override
    protected void createID() {
        this.id = "DS" + MENUCOUNTER.size();
    }

    @Override
    public String getLine() {
        String line = this.id + "," + this.name + "," + this.price + "," + this.description;
        return line;
    }

}
