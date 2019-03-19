package tests;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import controllers.FileHandler;

import models.item.Item;
import models.Order;

public class fileHandlerTest {

    public static void main(String[] args) {
        //testLoadMenu();
    	testLoadOrder();	
    }

    public static void testLoadMenu() {
        FileHandler fileHandler = new FileHandler();
        String path = "../CoffeShop/Data/menu.csv";

        try {
            HashMap<String, Item> testMenu = fileHandler.loadMenu(path);
            for (Map.Entry<String, Item> entry : testMenu.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testLoadOrder() {
        FileHandler fileHandler = new FileHandler();
        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";

        try {
            HashMap<String, Item> testMenu = fileHandler.loadMenu(menuPath);
            
            for (Map.Entry<String, Item> entry : testMenu.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }

            System.out.println("loadMenu done \n\n\n");
            Queue<Order> testQueue = fileHandler.loadOrders(orderPath, testMenu);
            for(Order order: testQueue){
                System.out.println(order);
                System.out.println("total: " + order.getTotalCost());
                System.out.println("discount: " + order.getDiscount());
            }
            System.out.println("loadOrder done");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}