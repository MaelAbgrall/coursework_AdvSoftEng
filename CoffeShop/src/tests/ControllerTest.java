package tests;

import controllers.Controller;
import models.Order;

//import org.junit.jupiter.api.Test;

public class ControllerTest {

    public static void main(String[] args) {
        //testLoad();
        //testQueue();
        //testPending();
        testAddOrder();
    }

    public static void testLoad() {
        Controller controller = new Controller();

        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";
        
        controller.load(menuPath, orderPath);
    }

    public static void testQueue() {
        Controller controller = new Controller();

        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";
        String staffName = "Bob";

        System.out.println("should be null: " + controller.processOrder(staffName));

        controller.load(menuPath, orderPath);

        System.out.println("Order: " + controller.processOrder(staffName));
        System.out.println("\tpending: " + controller.getPending());
        System.out.println("\tQueue size: " + controller.getWaiting().size());

        System.out.println("Order: " + controller.processOrder(staffName));
        System.out.println("\tpending: " + controller.getPending());
        System.out.println("\tQueue size: " + controller.getWaiting().size());
    }

    public static void testPending() {
        Controller controller = new Controller();

        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";
        String staffName = "Bob";

        //shoud return err message
        controller.completeOrder(staffName);

        controller.load(menuPath, orderPath);

        System.out.println("Order: " + controller.processOrder(staffName));
        System.out.println("\tpending: " + controller.getPending());
        System.out.println("\tQueue size: " + controller.getWaiting().size());
        
        //moving from pending to complete
        controller.completeOrder(staffName);
        System.out.println("hashmap size: " + controller.getPending().size());
        System.out.println("completed size: " + controller.getCompleted().size());
    }


    public static void testAddOrder() {
        Controller controller = new Controller();

        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";
        String staffName = "Bob";

        controller.load(menuPath, orderPath);

        Order order = controller.processOrder(staffName);
        System.out.println("Order: " + order);
        System.out.println("\tQueue size: " + controller.getWaiting().size());
        
        //moving from pending to complete
        controller.completeOrder(staffName);

        controller.addOrder(order);
        System.out.println("Queue size: " + controller.getWaiting().size());
    }

}
