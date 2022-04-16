package cart;

import menu.MenuItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    
    public double getFinalCartPrice() {
    	Scanner scan = new Scanner(System.in);
    	double theCartPrice = getTotalCartPrice();
        double tip;
        //Removed tipFunction.java class from iteration 1 and added to existing userCart method
        double finalPrice = 0.0;
        double tax = 0.114;
        //Standard restaurant tax in St. Louis		
        System.out.println("How much would you like to tip? Enter the percent amount without the % [Ex. use '15' for test case purposes]");
        tip = scan.nextDouble()/100;
        if (theCartPrice > 0) {
        	finalPrice = theCartPrice + (theCartPrice * tip) + (theCartPrice * tax);
        }
        scan.close();   // Yi's edit
        return finalPrice;
    }
}
