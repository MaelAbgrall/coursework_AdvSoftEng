package tests;

import controllers.Controller;

//import org.junit.jupiter.api.Test;

public class ControllerTest {

    public static void main(String[] args) {
        //testLoad();
        testQueue();
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

}
