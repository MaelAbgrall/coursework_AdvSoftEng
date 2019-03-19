package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import models.Order;
import models.item.Item;

public class FileHandler {

    /**
     * load the order csv file, populate the model and create a Queue
     * @param orderPath path to the order file
     */
    public Queue<Order> loadOrders(String orderPath){
        Queue<Order> loadedQueue = new LinkedList<>();
        //TODO: implement loadOrders
        return loadedQueue;
    }

    /**
     * load the menu csv file, populate the model and create a Hashmap
     * @param menuPath path toe the menu file
     */
    public HashMap<Item, String> loadMenu(String menuPath){
        HashMap<Item, String> loadedMenu = new HashMap<>();
        //TODO: implement loadMenu
        return loadedMenu;
    }

    /**
     * save the orderQueue
     * @param orderQueue the queue you want to save
     * @param path path to the file you want to save
     */
    public void saveOrderQueue(Queue<Order> orderQueue, String path){
        //TODO: implement saveOrderQueue
    }

    /**
     * save the menu
     * @param menu menu to save
     * @param path path to the file you want to save
     */
    public void saveMenu(HashMap<Item, String> menu, String path){
        //TODO: implement saveMenu
    }
}