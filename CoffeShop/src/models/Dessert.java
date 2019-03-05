package models;

/**
 * @author Ahmed ALJeferi
 *
 */
public class Dessert extends Item {

    public Dessert(String id, String name, Double price, String discrioption) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.discription = discrioption;
        MENUCOUNTER.add(id);
    }

    public Dessert(String name) {
        this.name = name;
        this.createID();
    }

    @Override
    public String createID() {
        int rdnm = MENUCOUNTER.size();
        this.id = "DS" + rdnm;
        MENUCOUNTER.add(this.id);
        return this.id;
    }

    @Override
    public String getLine() {
        String line = this.id + "," + this.name + "," + this.price + "," + this.discription;
        return line;
    }

}
