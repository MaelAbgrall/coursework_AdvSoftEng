package Model;

/**
 * @author Ahmed ALJeferi
 *
 */

import java.util.Date;
import java.util.TreeMap;

public class OrderList {
	
	
	TreeMap <Date,OrderProcessing> allData ;

	public OrderList() {
		// TODO Auto-generated constructor stub
	}
	public OrderProcessing getDayOrders (Date day){
		
		return allData.get(day);
		
		
	}

}
