package Model;
/**
 * @author Ahmed ALJeferi
 *
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MenuItems {

    

  /*   public static void main(String[] args) throws IOException {
        Set<Item> menuitem = new TreeSet<Item>();
        System.out.println("TEstttttt ");
        
        Scanner sc = new Scanner(System.in); 
        System.out.println("select the item type as 1:Drink 2:Food 3:Desert");
        int t = 0;
        try {
            t = Integer.parseInt(sc.next());
            
        } catch (Exception e) {
          
            System.out.println("wrong selection ");
        }
        String name = sc.next();
        sc.close();
        
        switch (t) {
            case 1:
            Item d = new Drink(name);
            menuitem.add(d);
            
                break;
        
            case 2:

                break;
            case 3:

                break;

        }
        loadToCSV("test.csv",menuitem);

             
        
    }
    public static void loadToCSV (String fileName, Set<Item> set) throws IOException{
        Iterator<Item> itr = set.iterator();
        FileWriter fw = new FileWriter(fileName);
    while (itr.hasNext()) {
    	Item i =itr.next();   	

    	fw.write(i.getLine());
    	   	
    }
    fw.close();        
    }
    */

    public void loadfrmCSV (String fileName){
        


    }
    public void loadToCSV (String fileName, Set<Item> set) throws IOException{
        Iterator<Item> itr = set.iterator();
        FileWriter fw = new FileWriter(fileName);
    while (itr.hasNext()) {
    	Item i =itr.next();   	

    	fw.write(i.getLine());
    	   	
    }
    fw.close();        
    }








}



