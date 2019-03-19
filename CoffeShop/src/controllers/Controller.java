package controllers;

import java.util.HashMap;
import java.util.Queue;

import models.item.Item;
import models.Order;

import controllers.FileHandler;

public class Controller {

    FileHandler fileHandler;
    //View view;    

    HashMap<Item, String> Menu;
    Queue<Order> waitingOrderQueue;
    Queue<Order> pendingOrderQueue;
    Queue<Order> completedOrderQueue;
    String logPath;

    public Controller(){
        //TODO: implement constructor
        this.fileHandler = new FileHandler();
    }

    /**
     * Load the menu and order files (CSV)
     * @param menuPath the path to the menu
     * @param orderPath the path to the order file
     */
    public void load(String menuPath, String orderPath){
        this.Menu = fileHandler.loadMenu(menuPath);
        System.out.println("Menu loaded");

        this.waitingOrderQueue = fileHandler.loadOrders(orderPath);
        System.out.println("Waiting Queue loaded");
    }

    public void exit(){
        //TODO: implement exit
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
    public Queue<Order> getWaiting(){
        return waitingOrderQueue;
    }

    /**
     * get the completedOrderQueue
     */
    public Queue<Order> getCompleted(){
        return completedOrderQueue;
    }
    
    
}