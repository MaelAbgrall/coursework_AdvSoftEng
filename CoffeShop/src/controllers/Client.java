package controllers;

import controllers.Controller;

/**
 * Staff
 * @param controller controller
 * @param timer sleep time (to control simulation speed)
 */
public class Client implements Runnable {
    Controller controller;
    Integer timer;

    public Client(Controller controller, Integer timer) {
        this.controller = controller;
        this.timer = timer;
        System.out.println("Client thread created.\n\tController: "+ this.controller + "\n\tTimer:" + this.timer);
    }

    public void run() { // the thread's code
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(this.timer);
                //counter.increment();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("job Done");
    }
}