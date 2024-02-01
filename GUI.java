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
    private int lastIntInput = 0;
    private boolean isClicked = false;
    private Main.ButtonActionListener buttonActionListener;
    private JLabel shoppingCartTitle,currentItemDetailsDisplay,currentItemIDDisplay, currentItemDetailsDisplayTwo,currentSubtotalDisplay;

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

        
       

        currentItemIDDisplay = new JLabel("Enter Item ID for Item 1");
        inputPanel.add(currentItemIDDisplay);
        
        inputPanel.add(itemIdInput);

        currentItemDetailsDisplay = new JLabel("Enter Quantity for Item 1");
        inputPanel.add(currentItemDetailsDisplay);
        inputPanel.add(quantityInput);
        
        currentItemDetailsDisplayTwo = new JLabel("Item Details for Item 1");
        inputPanel.add(currentItemDetailsDisplayTwo);
        inputPanel.add(itemDetailsDisplay);
        
        currentSubtotalDisplay = new JLabel("Current Subtotal for 1 Items");
        inputPanel.add(currentSubtotalDisplay);
        inputPanel.add(subtotalDisplay);
        itemDetailsDisplay.setEditable(false);
        subtotalDisplay.setEditable(false);
        
        // Adding the input panel to the NORTH of the main frame
        add(inputPanel, BorderLayout.NORTH);


        // Shopping Cart Display in the CENTER
        shoppingCart = new JPanel();
        shoppingCart.setLayout(new BoxLayout(shoppingCart, BoxLayout.Y_AXIS));
        shoppingCartTitle = new JLabel("Your shopping cart with: 0 items");
        shoppingCart.add(shoppingCartTitle);
        a1 = new JTextArea("");
        a2 = new JTextArea("");
        a3 = new JTextArea("");
        a4 = new JTextArea("");
        a5 = new JTextArea("");

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

        actionButtons[0].setText("Find Item 1");
        actionButtons[1].setText("Add Item 1 to Cart");
        actionButtons[2].setText("View Current Cart");
        actionButtons[3].setText("Check Out");
        actionButtons[4].setText("Empty Cart- Start New Order");
        actionButtons[5].setText("Exit (Close App)");

        
        
        
         // Use final variable for use in lambda
        actionButtons[0].addActionListener(e -> {//Find item 
            if (buttonActionListener != null) {
                lastInput = itemIdInput.getText();
                lastIntInput = Integer.parseInt(quantityInput.getText());
                buttonActionListener.onButtonClicked(0, getLastInput(),getLastIntInput());
            }
        });

        actionButtons[1].addActionListener(e -> {//Add items to cart
            if (buttonActionListener != null) {
                lastInput = itemIdInput.getText();
                buttonActionListener.onButtonClicked(1, getLastInput(),0);
            }
        });

        actionButtons[2].addActionListener(e -> {//view curr cart
            if (buttonActionListener != null) {
                lastInput = itemIdInput.getText();
                buttonActionListener.onButtonClicked(2, getLastInput(),0);
            }
        });

        actionButtons[3].addActionListener(e -> {//check out
            if (buttonActionListener != null) {
                lastInput = itemIdInput.getText();
                buttonActionListener.onButtonClicked(3, getLastInput(),0);
            }
        });

        actionButtons[4].addActionListener(e -> {//empty cart start new order
            if (buttonActionListener != null) {
                lastInput = itemIdInput.getText();
                buttonActionListener.onButtonClicked(4, getLastInput(),0);
            }
        });

        actionButtons[5].addActionListener(e -> {//Find item current
            if (buttonActionListener != null) {
                lastInput = itemIdInput.getText();
                buttonActionListener.onButtonClicked(5, getLastInput(),0);
            }
        });
        actionButtons[1].setEnabled(false);
        actionButtons[3].setEnabled(false);
        actionButtons[2].setEnabled(false);

        add(buttonPanel, BorderLayout.SOUTH);


       

        setVisible(true);
    
    }



    

    public JLabel getCurrentItemDetailsDisplay() {
        return currentItemDetailsDisplay;
    }





    public void setCurrentItemDetailsDisplay(JLabel currentItemDetailsDisplay) {
        this.currentItemDetailsDisplay = currentItemDetailsDisplay;
    }





    public JLabel getCurrentItemIDDisplay() {
        return currentItemIDDisplay;
    }





    public void setCurrentItemIDDisplay(JLabel currentItemIDDisplay) {
        this.currentItemIDDisplay = currentItemIDDisplay;
    }





    public JLabel getCurrentItemDetailsDisplayTwo() {
        return currentItemDetailsDisplayTwo;
    }





    public void setCurrentItemDetailsDisplayTwo(JLabel currentItemDetailsDisplayTwo) {
        this.currentItemDetailsDisplayTwo = currentItemDetailsDisplayTwo;
    }





    public JLabel getCurrentSubtotalDisplay() {
        return currentSubtotalDisplay;
    }





    public void setCurrentSubtotalDisplay(JLabel currentSubtotalDisplay) {
        this.currentSubtotalDisplay = currentSubtotalDisplay;
    }





    public boolean isClicked() {
        return isClicked;
    }

    


    public Main.ButtonActionListener getButtonActionListener() {
        return buttonActionListener;
    }





    public void setButtonActionListener(Main.ButtonActionListener buttonActionListener) {
        this.buttonActionListener = buttonActionListener;
    }





    public JLabel getShoppingCartTitle() {
        return shoppingCartTitle;
    }





    public void setShoppingCartTitle(JLabel shoppingCartTitle) {
        this.shoppingCartTitle = shoppingCartTitle;
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





    public int getLastIntInput() {
        return lastIntInput;
    }





    public void setLastIntInput(int lastIntInput) {
        this.lastIntInput = lastIntInput;
    }

    

}
