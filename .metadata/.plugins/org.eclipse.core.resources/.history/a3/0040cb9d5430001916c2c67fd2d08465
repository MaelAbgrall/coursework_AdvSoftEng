package Model;
/**
 * @author Ahmed ALJeferi
 *
 */

import java.util.ArrayList;

public abstract class Item implements Comparable<Item>{
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
	@Override
	public int compareTo(Item i) {
		// TODO Auto-generated method stub
		return this.id.compareTo(i.id);
	}
	
	
}
