package controllers;

import java.io.FileNotFoundException;
import java.text.ParseException;

import models.MenuItems;
import models.OrderList;

public class Controller {
    public float discountPercentage;
    private MenuItems menu;
    private OrderList orderList;

    /**
     * open a csv file specified by path and populate the model classes with it,
     * then save the object in the controller
     */
    public void loadMenu(String path) {
        MenuItems newMenu = new MenuItems();
        try {
            newMenu.loadFromCSV(path);
            menu = newMenu;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * load orders, then save the object in the controller
     */
    public void loadOrders(String path) {
        OrderList newOrderList = new OrderList();
        if (menu != null) {
            try {
                newOrderList.loadDataHistory(path, menu);
                orderList = newOrderList;
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("no menu are present, load a menu before calling loadOrders");
        }
    }

    /**
     * return the menu
     */
    public MenuItems getMenu(){
        return menu;
    }

    /**
     * return the order list
     */
    public OrderList getOrderList(){
        return orderList;
    }

    /**
     * check if a discount can be applied if yes, the variable discountPercentage is
     * updated
     * 
     * a discount can increase or decrease, and is always >0 & [0;1]
     */
    private void checkDiscount() {

    }

    /**
     * if an alcoholic beverage is present in the order, check if the user id allow
     * to buy it
     * 
     * @return false if the user can't buy, true if he can
     */
    private Boolean checkUserId() {
        return false;
    }

    /**
     * during the program exit, a report is generated one for the menu and the
     * number of item ordered one for the total income of the day
     */
    private void generateReport() {

    }

    /**
     * Constructor. Start the controller, bind the model and call the readcsv
     * function
     */
    /*
     * controller() {
     * 
     * }
     */

    /**
     * called when the program exits. delete all model objects, call the saveToCSV
     * and call the generateReport
     */
    public void exitProgram() {
        generateReport();
    }

    /**
     * add an item to an order
     */
    public void addToOrder() {
        checkDiscount();
    }

    /**
     * remove an item to an order
     * 
     * @throws Exception not implemented
     */
    public void removeFromOrder() throws Exception {
        throw new Exception("removeFromOrder not implemented");
        // checkDiscount();
    }

    /**
     * checkout (check for the user id, then process the order
     */
    public void checkout() {
        checkUserId();
    }

}