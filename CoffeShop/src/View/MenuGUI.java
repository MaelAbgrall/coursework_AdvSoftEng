package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Model.Item;
import Model.Drink;
import Model.MenuItems;

/**
 * 
 * @author stellahchonzi
 *
 */
 
public class MenuGUI implements ActionListener, ItemListener  {

    public JMenuBar createMenuBar() {
        //create a menu-bar
        JMenuBar menuBar;
        JMenu filemenu,submenu, editmenu;
        JMenu editsubmenu;
        JMenuItem menuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the  items menu.
        filemenu = new JMenu("Items");
        filemenu.setMnemonic(KeyEvent.VK_F);
        filemenu.getAccessibleContext().setAccessibleDescription("Cafe items.");
        menuBar.add(filemenu);

        //menu items, drinks section
        menuItem = new JMenuItem("Drinks",KeyEvent.VK_0);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);
        
      //a sub-menu for the drinks section, for selection
      
        submenu = new JMenu("Drinks submenu");
        submenu.setMnemonic(KeyEvent.VK_1);
            
 
        menuItem = new JMenuItem("Hot Drinks");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        
        // adding individual items to the sub-menu
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        
        
		
        
         l1.addElement("Cappuccino");  
          l1.addElement("Hot Chocolate");  
          l1.addElement("Latte");  
          l1.addElement("Americano");
          JList<String> list = new JList<>(l1);  
          list.setBounds(100,100, 75,75);  
          submenu.add(list);
          submenu.setSize(400, 400);
          submenu.setLayout(null);
          submenu.setVisible(true);
        

         menuItem = new JMenuItem("Cold drinks");
         menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
         submenu.add(menuItem);
         
         // adding individual items to the sub-menu
         DefaultListModel<String> l2 = new DefaultListModel<>();  
          l2.addElement("Pepsi");  
          l2.addElement("Coke");  
          l2.addElement("Spring Water");  
          l2.addElement("Fruit Juice");  
          JList<String> list2 = new JList<>(l2);  
          list2.setBounds(100,100, 75,75);  
          submenu.add(list2);
          submenu.setSize(400, 400);
          submenu.setLayout(null);
          submenu.setVisible(true);
          filemenu.add(submenu);
        
        
        
        
        //menu items, food section
        filemenu.addSeparator();
        menuItem = new JMenuItem("Food",KeyEvent.VK_1);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);
      
        //a sub-menu for the food section, available for selection
        
        submenu = new JMenu ("Food submenu");
        submenu.setMnemonic(KeyEvent.VK_3);
        
        menuItem = new JMenuItem("Hot Food");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        
        // adding individual items to the sub-menu
         DefaultListModel<String> l3 = new DefaultListModel<>();  
          l3.addElement("burger sandwich");  
          l3.addElement("Jacket Potato");  
          l3.addElement("Soup");  
          l3.addElement("sausage roll"); 
          JList<String> list3 = new JList<>(l3);  
          list3.setBounds(100,100, 75,75);  
          submenu.add(list3);
          submenu.setSize(400, 400);
          submenu.setLayout(null);
          submenu.setVisible(true);
          filemenu.add(submenu);

 
        menuItem = new JMenuItem("Cold food");
        submenu.add(menuItem);
        filemenu.add(submenu);
        
        // adding individual items to the sub-menu
         DefaultListModel<String> l4 = new DefaultListModel<>();  
          l4.addElement("cheese sandwich");  
          l4.addElement("chicken cesear");  
          l4.addElement("salad");  
          l4.addElement("ham sandwich");  
          JList<String> list4 = new JList<>(l4);  
          list4.setBounds(100,100, 75,75);  
          submenu.add(list4);
          submenu.setSize(400, 400);
          submenu.setLayout(null);
          submenu.setVisible(true);
          filemenu.add(submenu);

        
        
       //menu items, dessert section
        filemenu.addSeparator();
        menuItem = new JMenuItem("Dessert",KeyEvent.VK_4);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);     
        
        //a sub-menu for dessert section
        submenu = new JMenu ("Dessert submenu");
        submenu.setMnemonic(KeyEvent.VK_4);
        
        menuItem = new JMenuItem("Dessert submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
 
        menuItem = new JMenuItem("Available desserts");
        submenu.add(menuItem);
        filemenu.add(submenu);

        // adding individual items to the sub-menu
         DefaultListModel<String> l5 = new DefaultListModel<>();  
          l5.addElement("Brownies");  
          l5.addElement("Special chocolate cake");  
          l5.addElement("Carrot cake");  
          l5.addElement("milkshakes");  
          JList<String> list5 = new JList<>(l5);  
          list5.setBounds(100,100, 75,75);  
          submenu.add(list5);
          submenu.setSize(400, 400);
          submenu.setLayout(null);
          submenu.setVisible(true);
          filemenu.add(submenu);
        
        
        
       //edit menu in the  menu bar to add or remove available stock 
        editmenu = new JMenu(" Edit Available products");
        editmenu.setMnemonic(KeyEvent.VK_5);
        editmenu.getAccessibleContext().setAccessibleDescription("edit menu.");
        menuBar.add(editmenu);
         
        
        
        //menu items
        menuItem = new JMenuItem("Remove products",KeyEvent.VK_U);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);
       
        menuItem = new JMenuItem("Add products",KeyEvent.VK_R);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);
        
        return menuBar;
    }
       

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("A Coffee Shop Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuGUI menu = new MenuGUI();
        frame.setJMenuBar(menu.createMenuBar());

        /* show frame */
        frame.pack();
        frame.setSize(400,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem jmi = (JMenuItem)e.getSource();
        System.out.println("menu item clicked: " + jmi.getText());
        if (jmi.getText().equalsIgnoreCase("close")) {
            System.exit(0);
        }

    }
}