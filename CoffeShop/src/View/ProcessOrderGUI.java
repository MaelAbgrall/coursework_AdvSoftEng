package View;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;

import javax.swing.JFrame;
/**
 * 
 * @author stellahchonzi
 *
 */

 
  
public class ProcessOrderGUI extends JFrame {
	
	
	public static void main(String[] args) {  
        ProcessOrderGUI a = new ProcessOrderGUI();
        
    }

	public Component frame;  
	
	//Laying the processOrder View screen in GridBoxLayout form
	  public ProcessOrderGUI() {  
		   GridBagLayout GridBagLayout = new GridBagLayout();  
		            GridBagConstraints gbc = new GridBagConstraints();  
		            setLayout(GridBagLayout);  
		            setTitle("Process Order Demo");  
		            GridBagLayout layout = new GridBagLayout();
		            
		            
		            
		           
		                       
		            this.setLayout(layout);  
		            gbc.fill = GridBagConstraints.HORIZONTAL;  
		            gbc.gridx = 0;  
		            gbc.gridy = 0;  
		            this.add(new Button("FOOD"), gbc);
		            gbc.gridx = 1;  
		            gbc.gridy = 0;
		           
		            
		            this.add(new Button("DRINKS"), gbc);  
		            gbc.fill = GridBagConstraints.HORIZONTAL;  
		            gbc.ipady = 20;  
		            gbc.gridx = 0;  
		            gbc.gridy = 1;  
		            
		         
		            
		            this.add(new Button("DESSERTS"), gbc);  
		            gbc.gridx = 1;  
		            gbc.gridy = 1;  
		            
		 
		            
		          this.add(new Button("DISCOUNT"), gbc);  
		            gbc.gridx = 0;  
		            gbc.gridy = 2;  
		            
		      
		            gbc.fill = GridBagConstraints.HORIZONTAL;  
		            gbc.gridwidth = 2;  
		            this.add(new Button("PROCESS ORDER"), gbc);  
		                 
		            setSize(300, 300);  
		                    setPreferredSize(getSize());  
		                    setVisible(true);
		                  setDefaultCloseOperation(EXIT_ON_CLOSE);  
		          
		       
		          
		          
	
	
	
	  }
}
	
	
	