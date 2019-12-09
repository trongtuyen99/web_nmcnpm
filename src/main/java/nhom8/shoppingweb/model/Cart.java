package nhom8.shoppingweb.model;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }
 
    public Cart(HashMap<Integer, Integer> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void addItem(int id){
        cartItems.put(id, cartItems.getOrDefault(id, 0) + 1);
    }
    
    public void deleteItem(int id){
        cartItems.remove(id);
    }

    public HashMap<Integer, Integer> getCartItems() {
        return cartItems;
    }
   
}
