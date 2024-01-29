import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private List<Item> cart;
    private double subtotal;

    public Cart(){
        this.cart = new ArrayList<>();
        this.subtotal = 0.0;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    
}
