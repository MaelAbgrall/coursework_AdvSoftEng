package Model;

import java.io.File;

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
	public void getFiles (String path){
	File aDirectory = new File(path);
	String[] filesInDir = aDirectory.list();
	int count = 0  ;
	for (String x:filesInDir){			
		if (x.contains(".csv")){
			System.out.println(x);
			count ++;
		}	
	}
	System.out.println("The count is: "+ count);
	Date today = new Date ();
	today.setTime(System.currentTimeMillis());
	System.out.println(today.toString());	
    	}

}