import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class GUI extends JFrame {
    private JTextField itemIdInput, quantityInput, subtotalDisplay, itemDetailsDisplay;
    private JButton[] actionButtons = new JButton[6];
    private JPanel inputPanel,shoppingCart,buttonPanel;
    private JTextArea a1,a2,a3,a4,a5;
    private String lastInput = "";
    private boolean isClicked = false;
    private Main.ButtonActionListener buttonActionListener;

    public GUI(Main.ButtonActionListener buttonActionListener) {
        this.buttonActionListener = buttonActionListener;
        setTitle("CNT Project 1");
        setSize(800, 700); // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);

        setLayout(new BorderLayout(10, 10)); // Use BorderLayout

        // Panel for item ID and quantity inputs, now using FlowLayout
        inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        itemIdInput = new JTextField(40);
        quantityInput = new JTextField(40);
        itemDetailsDisplay = new JTextField(40);
        subtotalDisplay = new JTextField(40);

        
       


        inputPanel.add(new JLabel("Enter Item ID for Item #:"));
        inputPanel.add(itemIdInput);

        
        inputPanel.add(new JLabel("Enter Quantity for Item #:"));
        inputPanel.add(quantityInput);
        inputPanel.add(new JLabel("Item Details for Item #:"));
        inputPanel.add(itemDetailsDisplay);
        inputPanel.add(new JLabel("Current Subtotal for N Items:"));
        inputPanel.add(subtotalDisplay);
        itemDetailsDisplay.setEditable(false);
        subtotalDisplay.setEditable(false);
        
        // Adding the input panel to the NORTH of the main frame
        add(inputPanel, BorderLayout.NORTH);

        // Shopping Cart Display in the CENTER
        shoppingCart = new JPanel();
        shoppingCart.setLayout(new BoxLayout(shoppingCart, BoxLayout.Y_AXIS));
        shoppingCart.add(new JLabel("Your shopping cart is: " + "Change here"));
        a1 = new JTextArea("Item 1");
        a2 = new JTextArea("Item 2");
        a3 = new JTextArea("Item 3");
        a4 = new JTextArea("Item 4");
        a5 = new JTextArea("Item 5");

        a1.setEditable(false);
        a2.setEditable(false);
        a3.setEditable(false);
        a4.setEditable(false);
        a5.setEditable(false);

        shoppingCart.add(a1);
        shoppingCart.add(a2);
        shoppingCart.add(a3);
        shoppingCart.add(a4);
        shoppingCart.add(a5);
        
        add(shoppingCart, BorderLayout.CENTER);
        

        // Buttons Panel at the SOUTH
        buttonPanel = new JPanel(new GridLayout(2, 3, 60, 30));
        for (int i = 0; i < actionButtons.length; i++) {
            
            actionButtons[i] = new JButton("Button " + (i + 1));
            actionButtons[i].setPreferredSize(new Dimension(100, 50));
            buttonPanel.add(actionButtons[i]);
        }

        actionButtons[0].setText("Find Item:");
        actionButtons[1].setText("Add Item # to Cart");
        actionButtons[2].setText("View Current Cart");
        actionButtons[3].setText("Check Out");
        actionButtons[4].setText("Empty Cart- Start New Order");
        actionButtons[5].setText("Find Item: Curr#");

        for (int i = 0; i < actionButtons.length; i++) {
            final int buttonIndex = i;

        } 
        
        actionButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastInput = itemIdInput.getText();
                
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);


       

        setVisible(true);
    }

    

    public boolean isClicked() {
        return isClicked;
    }

    


    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }



    public JTextField getItemIdInput() {
        return itemIdInput;
    }



    public void setItemIdInput(JTextField itemIdInput) {
        this.itemIdInput = itemIdInput;
    }



    public JTextField getQuantityInput() {
        return quantityInput;
    }



    public void setQuantityInput(JTextField quantityInput) {
        this.quantityInput = quantityInput;
    }



    public JTextField getSubtotalDisplay() {
        return subtotalDisplay;
    }



    public void setSubtotalDisplay(JTextField subtotalDisplay) {
        this.subtotalDisplay = subtotalDisplay;
    }



    public JTextField getItemDetailsDisplay() {
        return itemDetailsDisplay;
    }



    public void setItemDetailsDisplay(JTextField itemDetailsDisplay) {
        this.itemDetailsDisplay = itemDetailsDisplay;
    }



    public JButton[] getActionButtons() {
        return actionButtons;
    }



    public void setActionButtons(JButton[] actionButtons) {
        this.actionButtons = actionButtons;
    }



    public JPanel getInputPanel() {
        return inputPanel;
    }



    public void setInputPanel(JPanel inputPanel) {
        this.inputPanel = inputPanel;
    }



    public JPanel getShoppingCart() {
        return shoppingCart;
    }



    public void setShoppingCart(JPanel shoppingCart) {
        this.shoppingCart = shoppingCart;
    }



    public JPanel getButtonPanel() {
        return buttonPanel;
    }



    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    

    public JTextArea getA1() {
        return a1;
    }



    public void setA1(JTextArea a1) {
        this.a1 = a1;
    }



    public JTextArea getA2() {
        return a2;
    }



    public void setA2(JTextArea a2) {
        this.a2 = a2;
    }



    public JTextArea getA3() {
        return a3;
    }



    public void setA3(JTextArea a3) {
        this.a3 = a3;
    }



    public JTextArea getA4() {
        return a4;
    }



    public void setA4(JTextArea a4) {
        this.a4 = a4;
    }



    public JTextArea getA5() {
        return a5;
    }



    public void setA5(JTextArea a5) {
        this.a5 = a5;
    }

    public static void updateComponentSafely(Runnable updateCode) {
        if (SwingUtilities.isEventDispatchThread()) {
            updateCode.run();
        } else {
            SwingUtilities.invokeLater(updateCode);
        }
    }

    

    public String getLastInput() {
        return lastInput;
    }

    



    public void setLastInput(String lastInput) {
        this.lastInput = lastInput;
    }

}
