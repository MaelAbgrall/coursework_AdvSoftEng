package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class TestingRun {

	public TestingRun() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		OrderList ol = new OrderList();
		ol.getFiles("/home/msc/aaa50/Desktop/Github/coursework_AdvSoftEng/CoffeShop/src/Model");
		MenuItems mi = new MenuItems();
		Item i = new Food("FD123", "Chees Sandwitch", 5.2, "Toast with two type of chees");
		Item i2 = new Food("FD124", "burgher Sandwitch", 7.2, "chees burgur");
		Drink i3 = new Drink("DR124", "Martinee", 3.5, "secruit drink");
		Item i4 = new Dessert("DS126","Braunies",2.5,"Sepecial choclate cake");
		i3.alcohoic = true;
		mi.menuitem.add(i);
		mi.menuitem.add(i2);
		mi.menuitem.add(i3);
		mi.menuitem.add(i4);
		mi.loadToCSV("Menue.csv", mi.menuitem);
		/*mi.loadfrmCSV("Menue.csv");
		 Iterator<Item> itr = mi.menuitem.iterator();
		 System.out.println(mi.menuitem.size());
	     
	    while (itr.hasNext()) {
	    	Item i =itr.next();
	    	System.out.println(i.getLine());
	    	   	
	    }*/
		
	
		
		

	}

}