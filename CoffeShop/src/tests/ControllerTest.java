package tests;

import controllers.Controller;

//import org.junit.jupiter.api.Test;

public class ControllerTest {

    public static void main(String[] args) {
        testLoad();
    }

    public static void testLoad() {
        Controller controller = new Controller();

        String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";
        
        controller.load(menuPath, orderPath);
    }

}
