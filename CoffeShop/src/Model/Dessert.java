package Model;

/**
 * @author Ahmed ALJeferi
 *
 */
public class Dessert extends Item {
	
	

	public Dessert(String name , String id , Double price , String discrioption) {
        this.name = name ;
        this.id = id ;
        this.price = price;
        this.discription = discrioption;
        MENUCOUNTER.add(id);
	}
	public Dessert(String name ) {
        this.name = name ;
        this.createID();
	}

	@Override
	public String createID() {
        int rdnm = MENUCOUNTER.size();
        this.id  = "DS" + rdnm;
        MENUCOUNTER.add(this.id);
        return this.id;
	}
	



}
