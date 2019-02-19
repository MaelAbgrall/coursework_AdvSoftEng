package Model;


import java.util.Date;
import java.util.TreeMap;

/**
 * @author ALI AHMAD A ALASMARE 
 *
 */

public class Order {
	String id ;
	Date d = new Date();
	Customer customer;
	TreeMap<Item,Integer> items ;
	Boolean preperedFlag = false;
	Double totalCost ;
	
	public Order() {
		
		d.setTime(System.currentTimeMillis());
		
	}
	
	public void addItem (Item item , int count){
		
	}

	public Boolean getPreperedFlag() {
		return preperedFlag;
	}

	public void setPreperedFlag(Boolean preperedFlag) {
		this.preperedFlag = preperedFlag;
	}
	

}
