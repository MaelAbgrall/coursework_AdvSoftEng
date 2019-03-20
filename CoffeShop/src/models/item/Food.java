package models.item;

/**
 * Food
 */
public class Food extends Item{

    public Food(String id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        // this.description = description;
    }
}