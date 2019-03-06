package models;

/**
 * @author Ahmed ALJeferi
 *
 */

public class Food extends Item {

    /**
     * Create a food object and add it to the MENUCOUNTER. This constructor should 
     * be called when creating a object from a file (ID already known)
     * 
     * Attributes: id String, name String, price Double, description String
     */
    public Food(String id, String name, Double price, String description) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;

        MENUCOUNTER.add(id);
    }


    /**
     * Create a food object and add it to the MENUCOUNTER. this constructor
     * should be called when creating objects from program
     * 
     * Attributes: name String
     */
    public Food(String name) {
        this.name = name;

        this.createID();
        MENUCOUNTER.add(id);
    }

    /*
    @Override
    public String createID() {
        // why creating a variable ? you can do this on one line and save time/space by not allocating memory
        int rdnm = MENUCOUNTER.size();
        
        // this line is already specifying that the attribute = your generated string
        this.id = "FD" + rdnm;

        //LINUX PHILOSOPHY: a function should do ONE and ONLY ONE thing (here create and ID, not add to MENUCOUNTER, which is the task of constructors)
        MENUCOUNTER.add(this.id);

        // here you return this attribute, although it's never used in the code. It's clearer and more logic to use a private void, since the goal is only to create an ID for the class (we do not use it anywhere else)
        return this.id;

        // since you're not using the function anywere else than in the constructor, a save alternative is to set it to protected, 
        // so only the class can call it, and only when creating a new object
    }
    */

    /**
     * Create the ID using the MENUCOUNTER size and the prefix DR
     */
    @Override
    protected void createID() {
        this.id = "FD" + MENUCOUNTER.size();
    }

    @Override
    public String getLine() {
        String line = this.id + "," + this.name + "," + this.price + "," + this.description;
        return line;
    }

}