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
    
    //An abstract method that need to be declared in each child class to have different type of id based on the 
    //type of the object to be easy in load data from file.
    protected abstract void createID();

    //and abstract method to return the information of an item in line comma separated value to be used in store in file 
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
    //In stage two we decide not to use tree in Menu Class so compareTo method in this class doesn't need any more
/*
    @Override
    public int compareTo(Item i) {
        // TODO Auto-generated method stub
        return this.id.compareTo(i.id);
    }*/

}
