package Model;

/**
 * @author Ahmed ALJeferi
 *
 */

public class Drink extends Item {
	
	public boolean alcohoic = false;

	public Drink(String name , String id , Double price , String discrioption) {
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
	

}
