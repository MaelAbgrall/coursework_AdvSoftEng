package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author ALI AHMAD A ALASMARE 
 *
 */

public class OrderProcessing {
	
	LinkedList<Order> underProcssOrdr ;
	LinkedList<Order> procssedOrdr ;
	private MenuItems menuItems ;

	public OrderProcessing() {
		
	}
	
	public void addOrder(Order order){
		this.underProcssOrdr.add(order);
					}
	
	public void completOrder (Order order){
		this.procssedOrdr.add(this.underProcssOrdr.remove(this.underProcssOrdr.indexOf(order)));
		order.setPreperedFlag(true);
				
	}
	public void setMenuItems (MenuItems m){
		this.menuItems = m;
	}
	/**
	 * @author AHMED A ALJEFERI 
	 * @throws ParseException 
	 *
	 */
	public void readLine (String line) throws ParseException{
		String[] record = line.split(",");
		Boolean flag = false;
		for (Order order : this.procssedOrdr){  //Loop in array of orders 
			if (order.id == record[3]){			// if order are in the list
				flag = true;
				Item item = this.menuItems.getItmeByID(record[0]);  //get the order object
				if (order.items.containsKey(item)){			//check if the item in the item list in the order
					Integer count = order.items.get(item);
					count ++;					//Increment the number of the item in the list
					order.items.replace(item, count);				
				
				}
				else {  //add new item to the existing order 
					order.addItem(item, 1);
				}
				break;
			}	
		
		}
		if (!flag){
			Customer c = new Customer (record[2],record[4]);
			Order ordr = new Order(record[0],c);
			SimpleDateFormat formatter6 =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date d = formatter6.parse(record[1]);
			ordr.setDate(d);
			Item item = this.menuItems.getItmeByID(record[0]);
			ordr.addItem(item, 1);
			this.procssedOrdr.add(ordr);	
			
			
		}
	}
	

}

