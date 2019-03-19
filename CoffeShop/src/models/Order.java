package models;

import java.util.Date;
import java.util.LinkedList;

import models.item.Item;


/**
 * Order
 */
public class Order {

    private LinkedList<Item> itemList;
    private String id;
    private Date dateTime;
    private Double totalCost;
    private Boolean discount;

    private Customer customer;

    public Order(String id, Customer customer, Date dateTime) {
        this.setItemList(new LinkedList<>());
        this.dateTime = dateTime;
        this.id = id;
    }

    /**
     * @return the itemList
     */
    public LinkedList<Item> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(LinkedList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item){
        this.itemList.add(item);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the discount
     */
    public Boolean getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    /**
     * @return the totalCost
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

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    
}