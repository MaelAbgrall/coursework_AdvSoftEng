package views;

import java.io.File;
import java.io.FileNotFoundException;

public class StartMenuApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            MenuGUI guiFrame = new MenuGUI("/Users/stellahchonzi/eclipse-workspace/SE1/src/CoffeShop/Data/menu.csv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
