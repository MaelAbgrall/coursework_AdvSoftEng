
import java.awt.*;
import javax.swing.*;

public class ActivityLog extends JFrame {
	

	
	public ActivityLog() {
		
		JLabel L1 = new JLabel("Order Queue");
		JLabel L2 = new JLabel("Server1");
		JLabel L3 = new JLabel("Server2");
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		BorderLayout B = new BorderLayout();
		
		//properties

		frame.setTitle("Activity Log");
    frame.setSize(600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(B);
		

		add(L1, B.NORTH);
		add(L2, B.CENTER);
		add(L3, B.EAST);
		
		/*setLayout(new BorderLayout());
		
		JPanel top= new JPanel();
		top.setLayout(new FlowLayout());
		JPanel left = new JPanel();
		left.setLayout(new FlowLayout());
		JPanel right = new JPanel();
		right.setLayout(new FlowLayout());
	
		
	
		
		//these are the labels of the panels
		top.add(new Label("Order Queue"));
		left.add(new Label("Server1"));
		right.add(new Label("Server2"));
		
		
		//add panel to borderlayout
		add("Order Queue", top);
		add("Server1", left);
		add("Server2", right);
		*/
		setVisible(true);
		
	}
//To test//	
	public static void main(String[] args) {
		
		ActivityLog gui = new ActivityLog();
		
		
	}
	

}



