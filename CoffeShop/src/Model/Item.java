package Model;

import java.util.ArrayList;

public abstract class Item {
	protected final static ArrayList<String> MENUCOUNTER  = new ArrayList<String>();
	public String name ; 
	public String id;
	public Double price;
	public String discription;
	
	public abstract String createID (); 
	public void setPrice (Double price){
		this.price = price;
	}
	public void setDiscripton (String discripton){
		this.discription = discripton;		
	}
	
}
