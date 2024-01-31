/* Name: <Daniel Rojas>
Course: CNT 4714 – Spring 2024
Assignment title: Project 1 – An Event-driven Enterprise Simulation
Date: Sunday January 28, 2024
*/

import javax.swing.*;

import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;

public class Main {

    public interface ButtonActionListener {
        void onButtonClicked(int buttonIndex, String additionalData);
    }

    public static void main(String[] args) {
         Cart availableStock = new Cart();
        Cart eCart = new Cart(); 
        
        readItemsFromFile("inventory.csv",availableStock.getCart());
        for (Item items : availableStock.getCart()) {
            System.out.println(items.toString());
        }
        final GUI[] myGUIHolder = new GUI[1];
        SwingUtilities.invokeLater(() -> {
            myGUIHolder[0] = new GUI(new ButtonActionListener() {
                @Override
                public void onButtonClicked(int buttonIndex, String additionalData) {
                    switch (buttonIndex) {
                        case 0:
                            System.out.println("Button 1 clicked, data: " + additionalData);
                            // Logic for button 1 click
                            break;
                        case 1:
                            System.out.println("Button 2 clicked, data: " + additionalData);
                            // Logic for button 2 click
                            break;
                        case 2:
                            System.out.println("Button 3 clicked, data: " + additionalData);
                            // Logic for button 3 click
                            break;
                        case 3:
                            System.out.println("Button 4 clicked, data: " + additionalData);
                            // Logic for button 4 click
                            break;
                        case 4:
                            System.out.println("Button 5 clicked, data: " + additionalData);
                            // Logic for button 5 click
                            break;
                        case 5:
                            System.out.println("Button 6 clicked, data: " + additionalData);
                            // Logic for button 6 click
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

    public static boolean searchStock(ArrayList<Item> stockList,String idString){
        for (int index = 0; index < stockList.size(); index++) {
            if (stockList.get(index).getItemId().equalsIgnoreCase(idString)) {
                return true;
            }
        }
        return false;
    }

}

