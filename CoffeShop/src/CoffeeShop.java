import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import controllers.Client;
import controllers.Controller;
import controllers.Staff;

/**
 * CoffeeShop
 */
public class CoffeeShop {

	public static void main(String[] args) {
		// output to logfile if there is no CLI argument
		if (args.length > 0) {
			System.out.println(args[0]);
		} else {
			// Creating a File object that represents the disk file.
			PrintStream outFile;
			try {
				outFile = new PrintStream(new File("logfile.log"));
				// Store current System.out before assigning a new value
				PrintStream console = System.out;

				// Assign o to output stream
				System.setOut(outFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		// simulation parameters
		Integer clientTimer = 100;
		Integer staffTimer = 200;

		// paths
		String menuPath = "../CoffeShop/Data/menu.csv";
		String orderPath = "../CoffeShop/Data/order1.csv";
		String orderPath2 = "../CoffeShop/Data/order2.csv";
		String internetOrderPath = "../CoffeShop/Data/internetOrder.csv";
		String reportPath = "../CoffeeShop/log/";

		// create the controller
		Controller controller = new Controller();
		controller.load(menuPath, orderPath);

		// create threads
		Thread client = new Thread(new Client(controller, controller.getfileHandler(), controller.getMenu(),
				clientTimer, orderPath2, internetOrderPath));
		Thread waiter1 = new Thread(new Staff(controller, "Joe", staffTimer));
		Thread waiter2 = new Thread(new Staff(controller, "Bob", staffTimer));

		// start simulation
		client.start();
		waiter1.start();
		waiter2.start();

		// stay awake until the threads finished their job
		while(true){ 
			if(waiter1.isAlive() == false && waiter2.isAlive() == false){
				break;
			}
		}

		// exit the program
		//controller.exit(reportPath);

	}
}