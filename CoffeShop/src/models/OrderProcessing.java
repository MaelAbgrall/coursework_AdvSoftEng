package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author ALI AHMAD A ALASMARE
 *
 */

public class OrderProcessing {

    LinkedList<Order> orderUnderProcess;
    LinkedList<Order> orderProcessed;
    private MenuItems menuItems;

    public OrderProcessing() {

    }

    public void addOrder(Order order) {
        this.orderUnderProcess.add(order);
    }

    /**
     * Move a completed order from the underProcess to the Processed list
     * 
     * Attributes: order Order
     */
    public void completeOrder(Order order) {
        this.orderProcessed.add(this.orderUnderProcess.remove(this.orderUnderProcess.indexOf(order)));
        order.setPreparedFlag(true);
    }

    public void setMenuItems(MenuItems m) {
        this.menuItems = m;
    }

    /**
     * @author AHMED A ALJEFERI
     * @throws ParseException
     *
     */
    public String loadDayWork() {
        String records = "";
        for (Order ord : this.orderProcessed) {
            for (Item itm : ord.items.keySet()) {
                int count = ord.items.get(itm);
                for (int i = count; i == 0; i--) {
                    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String timeStamp = formatter6.format(ord.d);
                    records += itm.id + "," + timeStamp + "," + ord.customer.id + "," + ord.id + "," + ord.customer.name
                            + "\n";
                }
            }

        }
        return records;
    }

    public void readLine(String line) throws ParseException {
        String[] record = line.split(",");
        Boolean flag = false;

        // Loop in array of orders
        for (Order order : this.orderProcessed) {
            // if order are in the list
            if (order.id == record[3]) {
                flag = true;
                
                // get the order object
                Item item = this.menuItems.getItemByID(record[0]);
                
                // check if there is already an item here and increment the count
                if (order.itemTreeMap.containsKey(item)) {
                    order.itemTreeMap.replace(item, order.itemTreeMap.get(item) + 1);
                } 
                
                // Or add new item to the existing order
                else {
                    order.addItem(item, 1);
                }
                break;
            }
        }

        if (!flag) {
            // create a new customer
            Customer customer = new Customer(record[2], record[4]);
            // set the date
            SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date dateTime = formatter6.parse(record[1]);
            // create the order
            Order order = new Order(record[0], customer, dateTime);

            Item item = this.menuItems.getItemByID(record[0]);
            order.addItem(item, 1);
            this.orderProcessed.add(order);

        }
    }

}
