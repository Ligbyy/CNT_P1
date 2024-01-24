import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTextField itemIdInput, quantityInput, subtotalDisplay;
    private JTextArea itemDetailsDisplay, cartItemsDisplay;
    private JButton[] actionButtons = new JButton[6];

    public GUI() {
        setTitle("Shopping Cart Simulation");
        setSize(600, 700); // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Panel for item ID and quantity inputs
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        itemIdInput = new JTextField(20);
        quantityInput = new JTextField(20);
        
        inputPanel.add(new JLabel("Enter Item ID:"));
        inputPanel.add(itemIdInput);
        inputPanel.add(new JLabel("Enter Quantity:"));
        inputPanel.add(quantityInput);

        // Adding the input panel to the main frame
        add(inputPanel);

        // Item Details Display
        itemDetailsDisplay = new JTextArea(5, 50);
        itemDetailsDisplay.setEditable(false);
        add(new JLabel("Item Details:"));
        JScrollPane itemDetailsScroll = new JScrollPane(itemDetailsDisplay);
        add(itemDetailsScroll);

        // Subtotal Display
        subtotalDisplay = new JTextField(20);
        subtotalDisplay.setEditable(false);
        add(new JLabel("Subtotal:"));
        add(subtotalDisplay);

        // Cart Items Display
        cartItemsDisplay = new JTextArea(10, 50);
        cartItemsDisplay.setEditable(false);
        add(new JLabel("Items in Cart:"));
        JScrollPane cartItemsScroll = new JScrollPane(cartItemsDisplay);
        add(cartItemsScroll);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 6, 5, 5));
        for (int i = 0; i < actionButtons.length; i++) {
            actionButtons[i] = new JButton("Button " + (i + 1));
            buttonPanel.add(actionButtons[i]);
        }
        add(buttonPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
