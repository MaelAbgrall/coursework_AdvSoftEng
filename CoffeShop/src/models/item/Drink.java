package models.item;

/**
 * drink
 */
public class Drink extends Item {

    private boolean alcohol = false;

    public Drink(String id, String name, Double price, String description, boolean alcohol) {
        this.id = id;
        this.name = name;
        this.price = price;
        // this.description = description;
        this.setAlcohol(alcohol);
    }

    /**
     * @return the alcohol
     */
    public boolean isAlcohol() {
        return alcohol;
    }

    /**
     * @param alcohol the alcohol to set
     */
    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }
}