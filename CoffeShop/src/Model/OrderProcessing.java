package Model;

import java.util.LinkedList;

/**
 * @author ALI AHMAD A ALASMARE 
 *
 */

public class OrderProcessing {
	
	LinkedList<Order> underProcssOrdr ;
	LinkedList<Order> procssedOrdr ;

	public OrderProcessing() {
		
	}
	
	public void addOrder(Order order){
		this.underProcssOrdr.add(order);
					}
	
	public void completOrder (Order order){
		this.procssedOrdr.add(this.underProcssOrdr.remove(this.underProcssOrdr.indexOf(order)));
		
	}

}

