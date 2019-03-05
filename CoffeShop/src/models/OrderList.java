package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author Ahmed ALJeferi
 *
 */

import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class OrderList {

    TreeMap<Date, OrderProcessing> allData = new TreeMap<Date, OrderProcessing>();

    public OrderList() {
        // TODO Auto-generated constructor stub
    }

    public OrderProcessing getDayOrders(Date day) {

        return allData.get(day);
    }

    public void saveWorkDay(OrderProcessing ordProcessing, String storePath) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        String fielName = formatter.format(LocalDateTime.now()) + ".csv";
        FileWriter fw = new FileWriter(fielName);
        fw.write(ordProcessing.loadDayWork());
        fw.close();

    }

    // the controller need to load the menu and pass the menu object to the method
    // load all the history files in the directory
    public void loadDataHistory(String path, MenuItems menu) throws ParseException, FileNotFoundException {
        File aDirectory = new File(path);
        String[] filesInDir = aDirectory.list();

        for (String x : filesInDir) {
            if (x.contains(".csv")) {
                SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");
                Date d = formatter6.parse(x.substring(0, 10));
                if (this.allData.containsKey(d)) {
                    OrderProcessing op = new OrderProcessing();
                    op.setMenuItems(menu);
                    File dayFile = new File(path + x);
                    Scanner sc = new Scanner(dayFile);
                    while (sc.hasNextLine()) {
                        op.readLine(sc.nextLine());
                    }
                    this.allData.put(d, op);

                }

            }
        }
    }
}