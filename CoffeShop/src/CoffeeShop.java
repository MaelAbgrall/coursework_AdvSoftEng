import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import controllers.Controller;


/**
 * CoffeeShop
 */
public class CoffeeShop {

    public static void main(String[] args) {
		//output to logfile if there is no CLI argument
    	if (args.length > 0)
		{
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
        Controller controller = new Controller();

    }
}