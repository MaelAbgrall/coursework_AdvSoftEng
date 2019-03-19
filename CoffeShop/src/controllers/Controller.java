package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Queue;

import models.item.Item;
import models.Order;

import controllers.FileHandler;

public class Controller {

    FileHandler fileHandler;
    // View view;

    HashMap<String, Item> menu;
    Queue<Order> waitingOrderQueue;
    Queue<Order> pendingOrderQueue;
    Queue<Order> completedOrderQueue;
    String logPath;

    public Controller() {
        // TODO: implement constructor
        this.fileHandler = new FileHandler();
    }

    /**
     * Load the menu and order files (CSV)
     * 
     * @param menuPath  the path to the menu
     * @param orderPath the path to the order file
     */
    public void load(String menuPath, String orderPath) {
        try {
            this.menu = fileHandler.loadMenu(menuPath);
            System.out.println("Menu loaded");
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
            e.printStackTrace();
        }

        try {
            this.waitingOrderQueue = fileHandler.loadOrders(orderPath, this.menu);
            System.out.println("Waiting Queue loaded");
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
            e.printStackTrace();
        }
    }

    public void exit() {
        // TODO: implement exit
    }

    /**
     * get the pendingOrderQueue
     */
    public Queue<Order> getPending() {
        return pendingOrderQueue;
    }

    /**
     * get the waitingOrderQueue
     */
    public Queue<Order> getWaiting() {
        return waitingOrderQueue;
    }

    /**
     * get the completedOrderQueue
     */
    public Queue<Order> getCompleted() {
        return completedOrderQueue;
    }

}