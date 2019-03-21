package views;


import java.awt.*;
import controllers.Controller;
import models.Order;

import javax.swing.*;

public class ActivityLog extends JFrame {

	
	private JLabel label;
	private JButton button;
	private JTextArea textarea;

	public ActivityLog() {
		Controller controller = new Controller(); 
		setLayout(new BorderLayout());
		
		String menuPath = "../CoffeShop/Data/menu.csv";
        String orderPath = "../CoffeShop/Data/order1.csv";

		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Activity Log");

		JPanel top = new JPanel();
		//top.setLayout(new FlowLayout());
		JPanel left = new JPanel();
		//left.setLayout(new FlowLayout());
		JPanel right = new JPanel();
		//right.setLayout(new FlowLayout());
		controller.load(menuPath, orderPath);
		top.setLayout(new ScrollPaneLayout());
		top.setLayout(new GridLayout(controller.getWaiting().size(), 1));
		//Queue<Order> orders = controller.getWaiting();
	
		System.out.println(controller.getWaiting().size());
		
		for(Order o : controller.getWaiting() ) {
			top.add(new Label(o.getCustomer() + "\t\t\t\t" + o.getItemList().size() + " Items"));
		}
		// there are the labels of the panels
		top.setPreferredSize(new Dimension(350, 150));
	//	top.add(new Label("Order Queue"));
		
		left.add(new Label("Server1"));
		left.setPreferredSize(new Dimension(350, 150));
		
		right.add(new Label("Server2"));
		right.setPreferredSize(new Dimension(350, 150));

		// add panel to borderlayout
		add(top, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

		
		setVisible(true);

	}

//TO TEST RUN THIS
	/*public static void main(String[] args) {

		ActivityLog gui = new ActivityLog(); /*

	}
}
