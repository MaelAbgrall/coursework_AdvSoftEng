package tests;

import controllers.FileHandler;
import controllers.Client;
import controllers.Controller;

/**
 * ClientTest
 */
public class ClientTest {

    public static void main(String[] args) {
        testClient();
    }

    public static void testClient() {
        FileHandler fileHandler = new FileHandler();
        Controller controller = new Controller();

        Integer timer = 1000;

        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";
        String orderPath2 = "../CoffeShop/Data/order2.csv";
        String internetOrderPath = "../CoffeShop/Data/internetOrder.csv";
        controller.load(menuPath, orderPath);

        Thread client = new Thread(new Client(controller, fileHandler, controller.getMenu(), timer, orderPath2, internetOrderPath));

        client.start();
    }
}