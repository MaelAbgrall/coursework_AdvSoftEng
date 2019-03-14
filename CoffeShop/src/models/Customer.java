package models;

/**
 * @author ALI AHMAD A ALASMARE
 *
 */
//The Custormer class is used to have a record of each customer visit the coffee shop 
//However, each order should has an instance of a customer object

public class Customer {

    String name;
    String id;
    
   
    //The constructor of customer take string as an id and another one as name of the customer
    public Customer(String id, String name) {
        this.name = name;
        this.id = id;

    }

}
