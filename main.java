/* Name: <Daniel Rojas>
Course: CNT 4714 – Spring 2024
Assignment title: Project 1 – An Event-driven Enterprise Simulation
Date: Sunday January 28, 2024
*/

import javax.swing.*;

import javafx.event.ActionEvent;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;

public class Main {

    public interface ButtonActionListener {
        void onButtonClicked(int buttonIndex, String additionalData,int intInput);
    }

    public static void main(String[] args) {
        Cart availableStock = new Cart();
        Cart eCart = new Cart();
        Cart tentativeCart = new Cart(); 
        
        readItemsFromFile("inventory.csv",availableStock.getCart());
        for (Item items : availableStock.getCart()) {
            System.out.println(items.toString());
        }
        final GUI[] myGUIHolder = new GUI[1];
        SwingUtilities.invokeLater(() -> {
            myGUIHolder[0] = new GUI(new ButtonActionListener() {
                @Override
                public void onButtonClicked(int buttonIndex, String additionalData, int intInput) {
                    switch (buttonIndex) {
                        case 0://FIND ITEM
                        int isFound = -1;
                        isFound = searchStock(availableStock.getCart(), additionalData,intInput);//SEARCH STOCK WILL RETURN THE INDEX WHERE THE ITEM THAT IS LOOKED FOR IS STORED, OTHERWISE IT WILL RETURN 0
                            
                            if(isFound != 0 && isFound != 1){
                                myGUIHolder[0].getItemDetailsDisplay().setText(availableStock.getCart().get(isFound).toString());
                                tentativeCart.getCart().add(availableStock.getCart().get(isFound));
                                myGUIHolder[0].getActionButtons()[0].setEnabled(false);
                                
                                myGUIHolder[0].getActionButtons()[1].setEnabled(true);
                                myGUIHolder[0].getCurrentItemDetailsDisplayTwo().setText("Item Details for Item " + (eCart.getCart().size() + 1));
                                isFound = 0;
                            }else if(isFound == 1){
                               
                                JOptionPane.showMessageDialog(null, "Sorry, this item is out of stock, try another item", "Error", JOptionPane.ERROR_MESSAGE);
                                myGUIHolder[0].getQuantityInput().setText("");

                                

                            }else{
                                JOptionPane.showMessageDialog(null, "Item: #" + additionalData + " was not found in our stock", "Error", JOptionPane.ERROR_MESSAGE);
                                myGUIHolder[0].getItemIdInput().setText("");
                            myGUIHolder[0].getQuantityInput().setText("");
                            }
                            break;
                        case 1://ADD ITEM TO CART
                           
                            if (eCart.getCart().size() >=5) {
                                myGUIHolder[0].getActionButtons()[0].setEnabled(false);
                                
                                myGUIHolder[0].getActionButtons()[1].setEnabled(false);
                                break;
                            }
                           
                            isFound = searchStock(availableStock.getCart(), additionalData,intInput);
                            eCart.getCart().add(tentativeCart.getCart().get(0));
                            
                            myGUIHolder[0].getActionButtons()[3].setEnabled(true);
                            myGUIHolder[0].getActionButtons()[2].setEnabled(true);
                            if (eCart.getCart().size() == 1) {
                                myGUIHolder[0].getA1().setText(tentativeCart.getCart().get(0).toString());
                            }else if(eCart.getCart().size() == 2){
                                myGUIHolder[0].getA2().setText(tentativeCart.getCart().get(0).toString());
                            }else if(eCart.getCart().size() == 3){
                                myGUIHolder[0].getA3().setText(tentativeCart.getCart().get(0).toString());
                            }else if(eCart.getCart().size() == 4){
                                myGUIHolder[0].getA4().setText(tentativeCart.getCart().get(0).toString());
                            }else if(eCart.getCart().size() == 5){
                                myGUIHolder[0].getA5().setText(tentativeCart.getCart().get(0).toString());
                            }
                            double subtotal = 0.0;
                            for (int i = 0; i < eCart.getCart().size(); i++) {
                                subtotal += eCart.getCart().get(i).getUnitPrice();
                            }
                            eCart.setSubtotal(subtotal);
                            myGUIHolder[0].getSubtotalDisplay().setText("$" + Double.toString(subtotal));
                            myGUIHolder[0].getShoppingCartTitle().setText("Your shopping cart with: " + eCart.getCart().size() + " items.");
                            
                            myGUIHolder[0].getActionButtons()[0].setEnabled(true);
                            myGUIHolder[0].getActionButtons()[1].setEnabled(false);
                            tentativeCart.getCart().clear();
                            isFound = -1;
                            myGUIHolder[0].getItemIdInput().setText("");
                            myGUIHolder[0].getQuantityInput().setText("");
                            if (eCart.getCart().size() >=5) {
                                myGUIHolder[0].getActionButtons()[0].setEnabled(false);
                                
                                myGUIHolder[0].getActionButtons()[1].setEnabled(false);
                                break;
                            }
                            myGUIHolder[0].getCurrentItemIDDisplay().setText("Enter ID for Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getCurrentItemDetailsDisplay().setText("Enter Quantity for Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getCurrentItemDetailsDisplayTwo().setText("Item Details for Item " + (eCart.getCart().size() ));
                            myGUIHolder[0].getCurrentSubtotalDisplay().setText("Current Subtotal for " + (eCart.getCart().size() ) + " Items");
                            myGUIHolder[0].getActionButtons()[0].setText("Find Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getActionButtons()[1].setText("Add Item " + (eCart.getCart().size() + 1) + " To Cart");
                             
                            
                            break;
                        case 2://VIEW CURRENT CART
                            
                            StringBuilder sb = new StringBuilder();
        
                            for (int i = 0; i < eCart.getCart().size(); i++) {
                            
                            sb.append(i + 1).append(". ").append(eCart.getCart().get(i).toString());
                            
                         
                            if (i < eCart.getCart().size() - 1) {
                                sb.append("\n");
                            }
                        }

                            JOptionPane.showMessageDialog(null, sb, "Current Cart - Status", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 3:
                            StringBuilder csvSb = new StringBuilder();
                            
                            // Logic for button 4 click CHECK OUT
                            SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy, h:mm a z");
                            String currentDateAndTime = sdf.format(new Date());

                           
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("FINAL INVOICE\n\n");
                            sb2.append("Date: ").append(currentDateAndTime).append("\n\n");
                            sb2.append("Number of line items: ").append(eCart.getCart().size()).append("\n\n");
                            sb2.append("Item# / ID / Title / Price / Qty / Disc % / Subtotal:\n");

                            for (Item item : eCart.getCart()) {
                                sb2.append(item.toString()).append("\n");
                            }

                            sb2.append("\nOrder subtotal: $").append(String.format("%.2f", eCart.getSubtotal()))
                            .append("\nTax rate: ").append(String.format("%.0f%%", 0.06 * 100))
                            .append("\nTax amount: $").append(String.format("%.2f", eCart.getSubtotal() * 0.06))
                            .append("\n\nORDER TOTAL: $").append(String.format("%.2f", eCart.getSubtotal()))
                            .append("\n\nThanks for shopping");

                            // Display the message in JOptionPane
                            JOptionPane.showMessageDialog(null, sb2.toString(), "Final Invoice", JOptionPane.INFORMATION_MESSAGE);


                            SimpleDateFormat sdf2 = new SimpleDateFormat("ddMMyyyyHHmmss");
                            String transactionDate = sdf2.format(new Date());

                            // StringBuilder for CSV content
                            

                            // Loop through the eCart and append each item's toString
                            
                            SimpleDateFormat displayFormat = new SimpleDateFormat("MMMM d, yyyy, h:mm:ss a 'EST'");
                            String displayDate2 = displayFormat.format(new Date());
                            for (Item item : eCart.getCart()) {
                                csvSb.append(transactionDate).append(", ")
                                    .append(item.toString()).append(" ");
                                    csvSb.append(displayDate2 + "\n" );
                            }
                            csvSb.append("\n");

                            // Add subtotal, tax, and total to CSV
                            
                            
                            

                            // Write to CSV file
                            String fileName = "C:\\Users\\blueg\\VSCodeprojects\\CNT_P1\\transactions.csv";
                            try (FileWriter writer = new FileWriter(fileName, true)) {
                                writer.write(csvSb.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        case 4:
                            
                            // Logic for button 5 click, OR START NEW ORDER
                            eCart.getCart().clear();
                            tentativeCart.getCart().clear();
                            myGUIHolder[0].getA1().setText("");
                            myGUIHolder[0].getA2().setText("");
                            myGUIHolder[0].getA3().setText("");
                            myGUIHolder[0].getA4().setText("");
                            myGUIHolder[0].getA5().setText("");
                            myGUIHolder[0].getItemIdInput().setText("");
                            myGUIHolder[0].getQuantityInput().setText("");
                            myGUIHolder[0].getItemDetailsDisplay().setText("");
                            myGUIHolder[0].getSubtotalDisplay().setText("");
                            myGUIHolder[0].getShoppingCartTitle().setText("Your shopping cart with: " + eCart.getCart().size() + " items.");
                            myGUIHolder[0].getCurrentItemIDDisplay().setText("Enter ID for Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getCurrentItemDetailsDisplay().setText("Enter Quantity for Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getCurrentItemDetailsDisplayTwo().setText("Item Details for Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getCurrentSubtotalDisplay().setText("Current Subtotal for " + (eCart.getCart().size() + 1) + " Items");
                            myGUIHolder[0].getActionButtons()[0].setText("Find Item " + (eCart.getCart().size() + 1));
                            myGUIHolder[0].getActionButtons()[1].setText("Add Item " + (eCart.getCart().size() + 1) + " To Cart");
                            break;
                        case 5://CLOSE APP
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Unknown button clicked");
                            break;
                    }
                }
            });
        });

       
}

    public static void readItemsFromFile(String fileName, List<Item> cartItems) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {//a bunch of logic to read in the input from the .csv file
                String[] parts = line.split(", ");
                String itemId = parts[0].trim();
                String description = parts[1].replaceAll("\"", "").trim();
                String stockStatus = parts[2].trim();
                int quantity = Integer.parseInt(parts[3].trim());
                double unitPrice = Double.parseDouble(parts[4].trim());

            
                Item newItem = new Item(itemId,description,stockStatus,quantity,unitPrice);
                cartItems.add(newItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static int searchStock(ArrayList<Item> stockList,String idString,int quantity){
        
        for (int index = 0; index < stockList.size(); index++) {
            if ((stockList.get(index).getItemId().equalsIgnoreCase(idString)) && stockList.get(index).getQuantity() >= quantity) {//ITEM IS FOUND AND IS IN STOCK
                return index;
            }else if ((stockList.get(index).getItemId().equalsIgnoreCase(idString)) && stockList.get(index).getQuantity() < quantity) {//ITEM IS FOUND BUT IS NOT IN STOCK
                return 1;
            }
        }
        return 0;//ITEM IS NOT FOUND
    }

}

