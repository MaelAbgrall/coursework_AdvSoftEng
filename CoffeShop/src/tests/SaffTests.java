package tests;

import controllers.Controller;
import controllers.Staff;

/**
 * SaffTests
 */
public class SaffTests {

    public static void main(String[] args) {
        testThread();
    }

    public static void testThread() {
        Controller controller = new Controller();
        Integer timer = 5000;
        //Staff waiter1 = new Staff(controller, "Joe");
        //Staff waiter2 = new Staff(controller, "bob");
        Thread waiter1 = new Thread(new Staff(controller, "Joe", timer));
        Thread waiter2 = new Thread(new Staff(controller, "Bob", timer));

        waiter1.start();
        waiter2.start();
    }
}