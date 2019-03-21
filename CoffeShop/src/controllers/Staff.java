package controllers;

import controllers.Controller;

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
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(this.timer);
                //counter.increment();
                System.out.println("plop i'm thread " + this.staffName);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("thread" + this.staffName + "is exiting");
    }
}