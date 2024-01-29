import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTextField itemIdInput, quantityInput, subtotalDisplay, itemDetailsDisplay;
    private JButton[] actionButtons = new JButton[6];

    public GUI() {
        setTitle("CNT Project 1");
        setSize(800, 700); // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);

        setLayout(new BorderLayout(10, 10)); // Use BorderLayout

        // Panel for item ID and quantity inputs, now using FlowLayout
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        JPanel shoppingCart = new JPanel();
        shoppingCart.setLayout(new BoxLayout(shoppingCart, BoxLayout.Y_AXIS));
        shoppingCart.add(new JLabel("Your shopping cart is: " + "Change here"));
        JTextArea a1 = new JTextArea("Item 1");
        JTextArea a2 = new JTextArea("Item 2");
        JTextArea a3 = new JTextArea("Item 3");
        JTextArea a4 = new JTextArea("Item 4");
        JTextArea a5 = new JTextArea("Item 5");

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
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 60, 30));
        for (int i = 0; i < actionButtons.length; i++) {
            actionButtons[i] = new JButton("Button " + (i + 1));
            actionButtons[i].setPreferredSize(new Dimension(100, 50));
            buttonPanel.add(actionButtons[i]);
        }

        actionButtons[0].setText("Find Item: Curr#");
        actionButtons[1].setText("Add Item # to Cart");
        actionButtons[2].setText("View Current Cart");
        actionButtons[3].setText("Check Out");
        actionButtons[4].setText("Empty Cart- Start New Order");
        actionButtons[5].setText("Exit");
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
