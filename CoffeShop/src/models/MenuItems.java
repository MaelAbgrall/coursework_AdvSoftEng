package models;
/**
 * @author Ahmed ALJeferi
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MenuItems {
    public Set<Item> menuitem = new TreeSet<Item>();

    ////// this part for test pourpose only as it contain main and change things to
    ////// static
    /*
     * public static void main(String[] args) throws IOException {
     * 
     * Set<Item> menuitem = new TreeSet<Item>(); System.out.println("TEstttttt ");
     * 
     * Scanner sc = new Scanner(System.in);
     * System.out.println("select the item type as 1:Drink 2:Food 3:Desert"); int t
     * = 0; try { t = Integer.parseInt(sc.next());
     * 
     * } catch (Exception e) {
     * 
     * System.out.println("wrong selection "); } String name = sc.next();
     * sc.close();
     * 
     * switch (t) { case 1: Item d = new Drink(name); menuitem.add(d);
     * 
     * break;
     * 
     * case 2:
     * 
     * break; case 3:
     * 
     * break;
     * 
     * } loadToCSV("test.csv",menuitem);
     * 
     * 
     * 
     * } public static void loadToCSV (String fileName, Set<Item> set) throws
     * IOException{ Iterator<Item> itr = set.iterator(); FileWriter fw = new
     * FileWriter(fileName); while (itr.hasNext()) { Item i =itr.next();
     * 
     * fw.write(i.getLine());
     * 
     * } fw.close(); }
     */

    public MenuItems() {

    }

    public void loadfromCSV(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            String[] result = line.split(",");
            String type = result[0].substring(0, 2);
            Item temp;

            switch (type) {
            case "DR":
                Drink tempD = new Drink(result[0], result[1], Double.valueOf(result[2]), result[3]);
                if (result[4] == "true") {
                    tempD.alcohoic = true;
                }
                this.menuitem.add(tempD);
                break;
            case "DS":
                temp = new Dessert(result[0], result[1], Double.valueOf(result[2]), result[3]);
                this.menuitem.add(temp);

                break;
            case "FD":
                temp = new Food(result[0], result[1], Double.valueOf(result[2]), result[3]);
                this.menuitem.add(temp);

                break;
            }

        }
        for (Item x : this.menuitem) {
            System.out.println(x.getLine());
        }

        //closing the file
        scan.close();
    }


    public void SaveToCSV(String fileName, Set<Item> set) throws IOException {
        Iterator<Item> itr = set.iterator();
        FileWriter fw = new FileWriter(fileName);
        while (itr.hasNext()) {
            Item i = itr.next();

            fw.write(i.getLine() + "\n");
        }
        fw.close();
    }


    public Item getItmeByID(String id) {
        Boolean flag = false;
        Item i = null;
        for (Item itm : this.menuitem) {
            if (itm.id.equals(id)) {
                i = itm;
            }

        }
        return i;
    }

}