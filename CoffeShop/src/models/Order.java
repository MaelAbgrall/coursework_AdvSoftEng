package models;

import java.util.Date;
import java.util.TreeMap;

/**
 * @author ALI AHMAD A ALASMARE
 * 
 *
 *         Create a new order
 * @param id       String
 * @param customer Customer object
 * @param dateTime Date
 *
 */

public class Order {
    String id;
    Date dateTime = new Date();
    Customer customer;
    TreeMap<Item, Integer> itemTreeMap;
    private Boolean preparedFlag = false;
    private Double totalCost;

    //TODO: never used 
    /*
     * public Order() { d.setTime(System.currentTimeMillis()); }
     */

    /**
     * Create a new order
     * 
     * @param id       String
     * @param customer Customer object
     * @param dateTime Date
     */
    public Order(String id, Customer customer, Date dateTime) {
        this.id = id;
        this.customer = customer;
        this.dateTime = dateTime;
    }

    /**
     * Set the date
     * 
     * @param dateTime date and time of the order (Date)
     */
    public void setDate(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * add an Item to the order. 
     * Careful this does not check if the item already exist
     * 
     * @param item  Item
     * @param count number of items (int)
     */
    public void addItem(Item item, int count) {
        itemTreeMap.put(item, count);
    }

    /**
     * Get the prepared flag
     * 
     * @return preparedFlag Boolean
     */
    public Boolean getPreparedFlag() {
        return preparedFlag;
    }

    /**
     * set the flag for prepared
     * 
     * @param preparedFlag boolean
     */
    public void setPreparedFlag(Boolean preparedFlag) {
        this.preparedFlag = preparedFlag;
    }

    /**
     * @return the totalCost of the order
     */
    public Double getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

}
