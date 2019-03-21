package views;


import java.awt.*;
import javax.swing.*;

public class ActivityLog extends JFrame {

	
	private JLabel label;
	private JButton button;
	private JTextArea textarea;

	public ActivityLog() {
		 
		setLayout(new BorderLayout());

		setSize(700, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Activity Log");

		JPanel top = new JPanel();
		//top.setLayout(new FlowLayout());
		JPanel left = new JPanel();
		//left.setLayout(new FlowLayout());
		JPanel right = new JPanel();
		//right.setLayout(new FlowLayout());
		//List<Order> orders = controller.getOrders();
		//for(Order o : orders ) {
		//	top.add(new Label(o.getName()));
		//}
		// these are the labels of the panels
		top.setPreferredSize(new Dimension(700, 150));
		top.add(new Label("Order Queue"));
		
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

	public static void main(String[] args) {

		ActivityLog gui = new ActivityLog();

	}
}
