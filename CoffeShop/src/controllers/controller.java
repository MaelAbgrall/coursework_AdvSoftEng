package controllers;

public class controller {
	public float discountPercentage;

	/**
	 * check if a discount can be applied if yes, the variable discountPercentage is
	 * updated
	 * 
	 * a discount can increase or decrease, and is always >0 & [0;1]
	 */
	private void checkDiscount() {

	}

	/**
	 * if an alcoholic beverage is present in the order, check if the user id allow
	 * to buy it
	 * 
	 * @return false if the user can't buy, true if he can
	 */
	private Boolean checkUserId() {
		return false;
	}

	/**
	 * during the program exit, a report is generated one for the menu and the
	 * number of item ordered one for the total income of the day
	 */
	private void generateReport() {

	}

	/**
	 * Constructor. Start the controller, bind the model and call the readcsv
	 * function
	 */
	controller() {

	}

	/**
	 * called when the program exits. delete all model objects, call the saveToCSV
	 * and call the generateReport
	 */
	public void exitProgram() {
		generateReport();
	}

	/**
	 * add an item to an order
	 */
	public void addToOrder() {
		checkDiscount();
	}

	/**
	 * remove an item to an order
	 * 
	 * @throws Exception not implemented
	 */
	public void removeFromOrder() throws Exception {
		throw new Exception("removeFromOrder not implemented");
		// checkDiscount();
	}

	/**
	 * checkout (check for the user id, then process the order
	 */
	public void checkout() {
		checkUserId();
	}

}