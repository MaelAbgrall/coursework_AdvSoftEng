package models;
/**
 * @author Ahmed ALJeferi
 *
 */

import java.util.ArrayList;

public abstract class Item implements Comparable<Item> {
    protected final static ArrayList<String> MENUCOUNTER = new ArrayList<String>();
    
    /*
    //changed to protected because it's easier to have methods (easier to maintain code if things change)
    public String name;

    //this variable is extremely important, it shouldn't be public.
    public String id;
    */

    protected String name;
    protected Double price;
    protected String description;
    protected String id;

    protected abstract void createID();

    //TODO: purpose?
    public abstract String getLine();

    /**
     * set the price of an Item object 
     * 
     * Attribute: Double price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * get the price of an Item object 
     * 
     * Return: Double price
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * set the description of an Item object 
     * 
     * Attribute: String description
     */
    public void setdescription(String description) {
        this.description = description;
    }

    /**
     * get the description of an Item object. 
     * 
     * Return: String description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * change the name of the object
     * 
     * Attribute: name String
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * get the name of the object
     * 
     * Return: name String
     */
    public String getName(){
        return this.name;
    }

    /**
     * get the ID of the object
     * 
     * Return: id String
     */
    public String getId(){
        return this.id;
    }

    @Override
    public int compareTo(Item i) {
        // TODO Auto-generated method stub
        return this.id.compareTo(i.id);
    }

}
