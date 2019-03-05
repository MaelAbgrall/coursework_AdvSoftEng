package models;

import java.util.Date;
import java.util.TreeMap;

/**
 * @author ALI AHMAD A ALASMARE
 *
 */

public class Order {
    String id;
    Date d = new Date();
    Customer customer;
    TreeMap<Item, Integer> items;
    private Boolean preperedFlag = false;
    Double totalCost;

    public Order() {
        d.setTime(System.currentTimeMillis());
    }

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void setDate(Date d) {
        this.d = d;
    }

    public void addItem(Item item, int count) {
        System.out.println("not implemented");
        System.exit(0);
    }

    public Boolean getPreperedFlag() {
        return preperedFlag;
    }

    public void setPreperedFlag(Boolean preperedFlag) {
        this.preperedFlag = preperedFlag;
    }

}
