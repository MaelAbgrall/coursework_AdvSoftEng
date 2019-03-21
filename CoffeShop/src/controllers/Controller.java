package controllers;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import models.item.Item;
import models.Order;

import controllers.FileHandler;

public class Controller {

    FileHandler fileHandler;
    // View view;

    HashMap<String, Item> menu;
    Queue<Order> waitingOrderQueue;
    HashMap<Order, String> pendingOrder;
    Queue<Order> completedOrderQueue;
    String logPath;

    public Controller() {
        // TODO: add link to the view
        this.fileHandler = new FileHandler();
        this.waitingOrderQueue = new LinkedList<>();
        this.pendingOrder = new HashMap<>();
        this.completedOrderQueue = new LinkedList<>();
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

    /**
     * exit the program and generate a report
     */
    public void exit() {
        Integer nbofCommands = 0;
        Double totalIncome = 0.;
        String report;
        String path = "../CoffeeShop/log/";

        for (Order order : completedOrderQueue) {
            nbofCommands += 1;

            if (order.getDiscount() == true) {
                totalIncome += order.getTotalCost() - 2.;
            }
            if (order.getDiscount() == false) {
                totalIncome += order.getTotalCost();
            }
        }

        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm");
        dateFormater.format(now);
        timeFormater.format(now);

        path += "report_" + dateFormater.format(now) + ".log";

        report = "DATE: " + dateFormater.format(now);
        report += "\nCOMPLETED AT: " + timeFormater.format(now);
        report += "\nCommands (TOTAL): " + nbofCommands;
        report += "\nIncome (DAY): " + totalIncome;

        fileHandler.saveReport(report, path);
    }

    /**
     * get the pendingOrderQueue
     */
    public HashMap<Order, String> getPending() {
        return pendingOrder;
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

    /**
     * return the first element from the Queue (FIFO) and remove it from the queue
     * Then add it to the pending hashmap. The return state is used to indicate to
     * kill of not the thread
     * 
     * @param staffName name of the thread
     * 
     * @return null if the waiting list is empty
     * @return order if the waiting list is not empty
     */
    public synchronized Order processOrder(String staffName) {
        // stop
        if (waitingOrderQueue.isEmpty() == true) {
            return null;
        }
        
        // or go on
        Order order = waitingOrderQueue.poll();
        this.pendingOrder.put(order, staffName);
        return order;
    }

    /**
     * Move an element from pendingOrder to CompleteOrderQueue
     */
    public synchronized void completeOrder() {

    }

    /**
     * Add an order to the waitingOrder Queue
     */
    public synchronized void addOrder() {

    }
}