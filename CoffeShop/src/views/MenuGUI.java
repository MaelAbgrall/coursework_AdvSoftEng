package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import models.item.*;
import controllers.FileHandler;
import models.item.Item;
import controllers.*;

//import CoffeShop.Data.*;

public class MenuGUI extends JFrame {

    private Double totalCost;
    private FileHandler menuRead;
    private JPanel receipt;
    private JPanel centerPanel;
    private JTextField orderPrice;
    private HashMap<String, Item> Order;
    private JTextPane orderItems;
    private String itemInformation;

    public MenuGUI(String filename) throws FileNotFoundException {
        /**
         * Initializing IVs
         */
        totalCost = new Double(0);
        itemInformation = "";

        Order = new HashMap<String, Item>();
        menuRead = new FileHandler();
        menuRead.loadMenu(filename);
        create();

        setSize(1500, 1500);
        setTitle("Restaurant Menu System");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * We use a border layout here We split the pane horizontally with the ordered
     * items on the right and item buttons to the left We get the panels for the
     * frame and put it in the divided pane
     * 
     * @throws FileNotFoundException
     */
    public void create() throws FileNotFoundException {
        JPanel mainPanel = (JPanel) getContentPane();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, getItemButtons(), getReceipt());

        splitPane.setDividerLocation(780);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.CENTER);

    }

    /**
     * An important method that allows for scrolling. This is crucial for long menus
     * that wont fit on the same screen The button panel is created in a standard
     * grid layout and eventually returns a scroll pane with all buttons
     * 
     * @return
     * @throws FileNotFoundException
     */
    // change location of menu.csv file before running the code
    private JScrollPane getItemButtons() throws FileNotFoundException {
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(0, 2));
        HashMap<String, Item> itemButtons = menuRead
                .loadMenu("/Users/stellahchonzi/eclipse-workspace/SE1/src/CoffeShop/Data/menu.csv");

        // LinkedList<Item> itemButtons = menuRead.getItem();
        /**
         * making a button for each item Adding action listeners so that they can
         * respond to clicks Refresh panel is a private method that updates the right
         * panel to reflect the current status of the order
         */

        Collection<Item> iterator = itemButtons.values();
        for (final Item itemButton : iterator) {

            final JButton createButton = new JButton(itemButton.getName());
            createButton.setToolTipText(itemButton.getName());

            createButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    refreshPanel(itemButton);
                }
            });
            pan.add(createButton);
            createButton.setPreferredSize(new Dimension(30, 60));

        }
        /**
         * Specifying the border specification and add a scroll pane to the main button
         * panel Specifying the nature of the border Returning scroller since we have
         * implemented a scrollable panel
         */
        JScrollPane scroller = new JScrollPane(pan);
        Border etchedBorder = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder(etchedBorder, "Items", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Lucida", Font.BOLD, 20), Color.BLACK);
        pan.setBorder(border);
        return scroller;

    }

    /**
     * Receipt panel deals with the current order Specify all the dimensions and
     * colors We add a scroll pane here too incase the order is very long The
     * textfield is constantly updated with the current price We set the
     * textfield.setEditable to false so that it cannot be altered by the user Place
     * order and Clear Order buttons are added here with their respective
     * ActionListeners
     * 
     * @return
     */
    private JPanel getReceipt() {

        receipt = new JPanel();
        JLabel label = new JLabel("Customer Order:");
        receipt.setLayout(new BorderLayout());

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BorderLayout());

        receipt.add(lowerPanel, BorderLayout.SOUTH);
        receipt.add(label, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1));

        orderItems = new JTextPane();
        centerPanel.add(orderItems);

        orderItems.setEditable(false);

        JScrollPane centerPanelScroller = new JScrollPane(centerPanel);
        receipt.add(centerPanelScroller, BorderLayout.CENTER);

        orderPrice = new JTextField(20);
        orderPrice.setText("Total Cost = £0.00");
        orderPrice.setEditable(false);

        JButton placeOrder = new JButton("Place Order");
        JButton clearOrder = new JButton("Clear Order");

        placeOrder.setPreferredSize(new Dimension(30, 50));
        clearOrder.setPreferredSize(new Dimension(30, 50));

        centerPanel.setBackground(Color.LIGHT_GRAY);
        placeOrder.setForeground(Color.BLUE);
        clearOrder.setForeground(Color.RED);

        placeOrder.setFont(new Font("Times New Roman", Font.BOLD, 40));
        clearOrder.setFont(new Font("Times New Roman", Font.BOLD, 40));

        clearOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                /**
                 * private method that clears all content
                 */
                delete();

            }

        });

        placeOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (!orderPrice.getText().equals("Total Cost = £0.00")) {

                        menuRead.loadOrders(itemInformation, Order);
                        // logOrder(Order, totalCost);
                        JOptionPane.showMessageDialog(getContentPane(), "Order has been sent to kitchen",
                                "Order has been logged", JOptionPane.INFORMATION_MESSAGE);
                        delete();
                    } else {
                        JOptionPane.showMessageDialog(null, "No items ordered", "Place order",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException g) {

                    JOptionPane.showMessageDialog(null, "Error! Program terminated", " Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        /**
         * Adding to the panel
         */

        lowerPanel.add(orderPrice, BorderLayout.NORTH);
        lowerPanel.add(placeOrder, BorderLayout.CENTER);
        lowerPanel.add(clearOrder, BorderLayout.SOUTH);
        lowerPanel.setBackground(Color.LIGHT_GRAY);
        receipt.setBackground(Color.WHITE);
        return receipt;

    }

    private void delete() {

        orderPrice.setText("Total Cost = £0.00");
        totalCost = 0.0;
        Order.clear();
        itemInformation = "";
        orderItems.setText(null);

    }

    /**
     * Constantly updates the order panel based on commands
     * 
     * @param itemButton
     */
    private void refreshPanel(final Item itemButton) {
        String item = itemButton.getName();
        Double itemPrice = itemButton.getPrice();
        itemInformation += "\n" + item + "\n" + itemPrice + "\n";
        orderItems.setText(itemInformation);
        Order.put("", itemButton);

        totalCost = totalCost + itemPrice;
        orderPrice.setText("Total cost = £" + totalCost);
    }

}
