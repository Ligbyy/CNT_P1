import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTextField itemIdInput, quantityInput, subtotalDisplay, itemDetailsDisplay,cartItemsDisplay;
    private JButton[] actionButtons = new JButton[6];

    public GUI() {
        setTitle("Shopping Cart Simulation");
        setSize(800, 700); // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        getContentPane().setBackground(Color.DARK_GRAY);

        // Panel for item ID and quantity inputs
        JPanel inputPanel = new JPanel();
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

        // Adding the input panel to the main frame
        add(inputPanel);
 
       

        // Cart Items Display
        cartItemsDisplay = new JTextField(40);
        inputPanel.add(new JLabel("Your shopping cart is: " + "Change here"));

        JPanel shoppingCart = new JPanel();
        shoppingCart.setBackground(Color.DARK_GRAY);
        shoppingCart.setLayout(new BoxLayout(shoppingCart, BoxLayout.Y_AXIS));
        add(shoppingCart);


       
       
        
        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 90, 80));
        add(buttonPanel);
       
        for (int i = 0; i < actionButtons.length; i++) {
            actionButtons[i] = new JButton("Button " + (i + 1));
            actionButtons[i].setSize(100,100);
            actionButtons[i].setPreferredSize(new Dimension(100, 50));
            buttonPanel.add(actionButtons[i]);
        }
        add(buttonPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
