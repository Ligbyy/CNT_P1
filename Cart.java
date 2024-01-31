import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private ArrayList<Item> cart;
    private double subtotal,taxRate;

    public Cart(){
        this.cart = new ArrayList<>();
        this.subtotal = 0.0;
        this.taxRate = 1.06;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }

    

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    
}
