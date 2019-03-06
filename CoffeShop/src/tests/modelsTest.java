package tests;

//Item and subclasses
import models.Item;
import models.Food;
//import models.Dessert;
//import models.Drink;


/**
 * modelsTest
 */
public class modelsTest {

    public static void main(String[] args) {
        testFood();
    }

    public static void testFood() {
        String name = "testfood";
        Double price = 3.;
        String description = "description of test item";

        Item testItem = new Food(name);
        testItem.setPrice(price);
        testItem.setdescription(description);

        System.out.println("id: " + testItem.getId());
        System.out.println("name: " + testItem.getName());
        System.out.println("desc: " + testItem.getDescription());
        System.out.println("price: " + testItem.getPrice());
    }
}