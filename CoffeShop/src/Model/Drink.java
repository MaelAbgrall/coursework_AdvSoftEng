package Model;

/**
 * @author Ahmed ALJeferi
 *
 */

public class Drink extends Item {
	
	public boolean alcohoic = false;

	public Drink(String id , String name , Double price , String discrioption) {
        this.name = name ;
        this.id = id ;
        this.price = price;
        this.discription = discrioption;
		MENUCOUNTER.add(id);
		
        }
        public Drink (String name){
        this.name = name ;
        this.createID();
        }

	@Override
	public String createID() {
        int rdnm = MENUCOUNTER.size();
        this.id  = "DR" + rdnm;
        MENUCOUNTER.add(this.id);
        return this.id;
	}
	@Override
	public String getLine() {
		String line = this.id+","+this.name+","+this.price+","+this.discription+","+this.alcohoic;
		return line;
	}
	

}
