package Model;

public class Food extends Item {
	
	

	public Food(String name , String id , Double price , String discrioption) {
        this.name = name ;
        this.id = id ;
        this.price = price;
        this.discription = discrioption;
        MENUCOUNTER.add(id);

        
	}

	@Override
	public String createID() {
        int rdnm = MENUCOUNTER.size();
        this.id  = "FD" + rdnm;
        MENUCOUNTER.add(this.id);
        return this.id;
	}

}