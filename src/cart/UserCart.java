package cart;

import menu.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class UserCart {
    private HashMap<MenuItem, Integer> cart = null;

    public UserCart() { cart = new HashMap<>(); }

    public boolean addToCart(MenuItem item, Integer amountToAdd) {
        if (item.getItemAmountInStock() < amountToAdd || amountToAdd <= 0) { return false; }
        if (cart.containsKey(item)) {
            int existingQuantity = cart.get(item);
            cart.replace(item, existingQuantity + amountToAdd);
            item.setItemAmountInStock(item.getItemAmountInStock() - amountToAdd);
        } else {
            cart.put(item, amountToAdd);
            item.setItemAmountInStock(item.getItemAmountInStock() - amountToAdd);
        }
        return true;
    }

    public boolean removeFromCart(MenuItem item, Integer amountToRemove) {
        if (!cart.containsKey(item) || cart.get(item) < amountToRemove || amountToRemove < 0) { return false; }
        if (cart.get(item).equals(amountToRemove)) {
            cart.remove(item);
            item.setItemAmountInStock(item.getItemAmountInStock() + amountToRemove);
        } else {
            int existingQuantity = cart.get(item);
            cart.replace(item, existingQuantity - amountToRemove);
            item.setItemAmountInStock(item.getItemAmountInStock() + amountToRemove);
        }
        return true;
    }

    public double getTotalCartPrice() {
        double cartPrice = 0.0;
        for (Map.Entry<MenuItem, Integer> cartItems : cart.entrySet()) {
            double itemPrice = cartItems.getKey().getItemPrice();
            int quantity = cartItems.getValue();
            cartPrice += itemPrice * quantity;
        }
        return cartPrice;
    }

    public double getTotalCalories() {
        double cartCalories = 0.0;
        for (Map.Entry<MenuItem, Integer> cartItems : cart.entrySet()) {
            double itemCals = cartItems.getKey().getItemCalories();
            int quantity = cartItems.getValue();
            cartCalories += itemCals * quantity;
        }
        return cartCalories;
    }

    public int getTotalItems() {
        int totalItems = 0;
        for (Map.Entry<MenuItem, Integer> cartItems : cart.entrySet()) {
            int quantity = cartItems.getValue();
            totalItems += quantity;
        }
        return totalItems;
    }
}
