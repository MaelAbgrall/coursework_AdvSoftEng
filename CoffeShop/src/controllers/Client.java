package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Queue;

import controllers.Controller;
import models.Order;
import models.item.Item;

/**
 * Staff
 * 
 * @param controller controller
 * @param timer      sleep time (to control simulation speed)
 */
public class Client implements Runnable {
    Controller controller;
    Integer timer;
    HashMap<String, Item> menu;
    FileHandler fileHandler;
    String orderPath;
    String internetOrderPath;
    Queue<Order> newWaitingOrderQueue;
    Queue<Order> internetOrderQueue;

    public Client(Controller controller, FileHandler fileHandler, HashMap<String, Item> menu, Integer timer,
            String orderPath, String internetOrderPath) {
        this.controller = controller;
        this.fileHandler = fileHandler;
        this.timer = timer;
        this.menu = menu;
        this.orderPath = orderPath;
        this.internetOrderPath = internetOrderPath;
        System.out.println(
                "Client thread created.\n\tController: " + this.controller + "\n\tFileHandler: " + this.fileHandler
                        + "\n\tOrderPath: " + this.orderPath + "\n\tInternetOrderPath: " + this.internetOrderPath + "\n\tTimer: " + this.timer + "\n\tMenu: " + this.menu);
    }

    public void run() {
        // load the new orders
        try {
            this.newWaitingOrderQueue = fileHandler.loadOrders(this.orderPath, this.menu);
            System.out.println("new waiting Queue loaded");
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
            e.printStackTrace();
        }

        // load the internet orders
        try {
            this.internetOrderQueue = fileHandler.loadOrders(this.internetOrderPath, this.menu);
            System.out.println("internet Queue loaded");
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
            e.printStackTrace();
        }

        this.slowDown();

        // while one of the queues is still containing elements
        while(this.newWaitingOrderQueue.isEmpty() == false || this.internetOrderQueue.isEmpty() == false){
            // add a new order to the waiting list
            if(this.newWaitingOrderQueue.isEmpty() == false){
                controller.addOrder(this.newWaitingOrderQueue.poll());
            }

            // add a new order to the internet waiting list
            if(this.internetOrderQueue.isEmpty() == false){
                controller.addOrder(this.internetOrderQueue.poll());
            }

            this.slowDown();
        }
        

        System.out.println("client thread done");
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