package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Map.Entry;

import models.Order;
import models.item.Item;
import models.item.Drink;
import models.item.Dessert;
import models.item.Food;

public class FileHandler {

    /**
     * load the order csv file, populate the model and create a Queue
     * 
     * @param orderPath path to the order file
     * @param menu      the menu hashmap
     * @throws FileNotFoundException
     */
    public Queue<Order> loadOrders(String orderPath, HashMap<String, Item> menu) throws FileNotFoundException {
        Queue<Order> loadedQueue = new LinkedList<>();

        HashMap<Integer, Order> tempHashmap = new HashMap<>();

        File file = new File(orderPath);
        Scanner scan = new Scanner(file);

        // read file
        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            // parsing each line in substrings using ","
            String[] result = line.split(",");

            Integer orderID = Integer.parseInt(result[0]);

            // if the order doesn't exist, create a new order
            Order order = tempHashmap.get(orderID);

            if (order == null) {
                // try to cast the string to a date format
                Date time = dateCast(result[1]);
                if (time != null) {
                    // create a new order
                    System.out.println("Creating order " + order);
                    order = new Order(result[0], result[3], time);
                    tempHashmap.put(orderID, order);
                }
            }

            // retrieve the item oject and add it to the order
            Item item = menu.get(result[2]);
            if (item != null) {
                order.addItem(item);
                System.out.println("\tAdding item " + item + " to order " + order);
                // calculate total and discount
                order.setTotalCost(calculateTotal(order));
                order.setDiscount(calculateDiscount(order));
            } else {
                System.err.println("ERROR with " + result[2]);
            }
        }

        // add now all element from the hashmap to the Queue
        for (Entry<Integer, Order> entry : tempHashmap.entrySet()) {
            loadedQueue.add(entry.getValue());
        }

        // closing the file
        scan.close();
        return loadedQueue;
    }

    /**
     * calculate the total cost of an order
     * 
     * @param order order
     * @return double total
     */
    public Double calculateTotal(Order order) {
        Double total = 0.;
        List<Item> itemList = order.getItemList();
        for (Item item : itemList) {
            total += item.getPrice();
        }

        return total;
    }

    /**
     * return if a discount can be applied (hard coded >=2 items = discount)
     * 
     * @param order order
     * @return boolean
     */
    public Boolean calculateDiscount(Order order) {
        Integer listSize = order.getItemList().size();
        Boolean discount;

        if (listSize < 2) {
            discount = false;
        } else {
            discount = true;
        }
        return discount;
    }

    /**
     * cast a string HH:mm to a Date format
     * 
     * @param dateString the string to cast
     * @return null or Date
     */
    public Date dateCast(String dateString) {
        SimpleDateFormat SDFtime = new SimpleDateFormat("HH:mm");
        Date time = null;
        try {
            time = SDFtime.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * load the menu csv file, populate the model and create a Hashmap
     * 
     * @param menuPath path toe the menu file
     * @throws FileNotFoundException
     */
    public HashMap<String, Item> loadMenu(String menuPath) throws FileNotFoundException {
        HashMap<String, Item> loadedMenu = new HashMap<>();

        File file = new File(menuPath);
        Scanner scan = new Scanner(file);

        // read the file
        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            // parsing each line in substrings using ","
            String[] result = line.split(",");
            String type = result[0].substring(0, 2);
            Item temp;

            // depending on the item type, create a Drink, Dessert or Food object
            switch (type) {
            case "DR":
                // default initialisation at false, if product is alcohol, set to true
                boolean alcohol = false;
                if (result[4] == "true") {
                    alcohol = true;
                }
                // call constructor
                temp = new Drink(result[0], result[1], Double.valueOf(result[2]), result[3], alcohol);

                // populate menu
                loadedMenu.put(result[0], temp);
                break;

            case "DS":
                temp = new Dessert(result[0], result[1], Double.valueOf(result[2]), result[3]);
                loadedMenu.put(result[0], temp);
                break;

            case "FD":
                temp = new Food(result[0], result[1], Double.valueOf(result[2]), result[3]);
                loadedMenu.put(result[0], temp);
                break;
            }

        }

        // closing the file
        scan.close();

        return loadedMenu;
    }

    /**
     * save the orderQueue
     * 
     * @param orderQueue the queue you want to save
     * @param path       path to the file you want to save
     */
    public void saveOrderQueue(Queue<Order> orderQueue, String path) {
        // TODO: implement saveOrderQueue
    }

    /**
     * save the menu
     * 
     * @param menu menu to save
     * @param path path to the file you want to save
     */
    public void saveMenu(HashMap<Item, String> menu, String path) {
        // TODO: implement saveMenu
    }

    public void saveReport(String report, String path) {
        //TODO test saveReport
        File reportFile = new File(path);
        try {
            reportFile.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        FileWriter fWrite;
        try {
            fWrite = new FileWriter(path);
            fWrite.write(report);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}