package controllers;

import controllers.Controller;
import models.Order;

/**
 * Staff
 */
public class Staff implements Runnable {
    Controller controller;
    String staffName;
    Integer timer;

    public Staff(Controller controller, String staffName, Integer timer) {
        this.controller = controller;
        this.staffName = staffName;
        this.timer = timer;
        System.out.println("Staff created.\n\tController: "+ controller + "\n\tName: " + staffName + "\n\tTimer: " + this.timer);
    }

    public void run() { // the thread's code
        // loop until there is no more order to process
        Order order;
        while(true){
            // wait
            this.slowDown();
            // waiting order -> pending order
            order = controller.processOrder(this.staffName);
            if(order == null){
                System.out.println("No more order for " + this.staffName);
                break;
            }
            System.out.println(this.staffName + " is processing order " + order.getId());

            //wait
            this.slowDown();
            // pending order -> completed order
            controller.completeOrder(this.staffName);
            System.out.println(this.staffName + " completed order no " + order.getId());

        }
        System.out.println(this.staffName + " has finished working.");
    }

    /**
     * Slow down the thread by waiting according to this.timer
     */
    public void slowDown() {
        try {
            Thread.sleep(this.timer);
            //counter.increment();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}