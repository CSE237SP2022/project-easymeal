package cart;

import menu.MenuItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the cart functionality.
 */
public class UserCart {
    private HashMap<MenuItem, Integer> cart;
    public UserCart() { cart = new HashMap<>(); }

    /**
     * @param item A menu item
     * @param amountToAdd Number of menu items to add
     * @return True if added to cart successfully
     */
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

    /**
     * @param item A menu item
     * @param amountToRemove Number of menu items to remove
     * @return True if removed from cart successfully
     */
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

    /**
     * @return Price of all items in cart
     */
    public double getTotalCartPrice() {
        double cartPrice = 0.0;
        for (Map.Entry<MenuItem, Integer> cartItems : cart.entrySet()) {
            double itemPrice = cartItems.getKey().getItemPrice();
            int quantity = cartItems.getValue();
            cartPrice += itemPrice * quantity;
        }
        return cartPrice;
    }

    /**
     * @return Total number of calories of items in cart
     */
    public double getTotalCalories() {
        double cartCalories = 0.0;
        for (Map.Entry<MenuItem, Integer> cartItems : cart.entrySet()) {
            double itemCals = cartItems.getKey().getItemCalories();
            int quantity = cartItems.getValue();
            cartCalories += itemCals * quantity;
        }
        return cartCalories;
    }

    /**
     * @return Number of items in cart
     */
    public int getTotalItems() {
        int totalItems = 0;
        for (Map.Entry<MenuItem, Integer> cartItems : cart.entrySet()) {
            int quantity = cartItems.getValue();
            totalItems += quantity;
        }
        return totalItems;
    }

    /**
     * @return Final cart price after tips and tax
     */
    public double getFinalCartPrice() {
    	Scanner scan = new Scanner(System.in);
    	double theCartPrice = getTotalCartPrice();
        double tip;
        double finalPrice = 0.0;
        double tax = 0.114;
        //Standard restaurant tax in St. Louis		
        System.out.println("Subtotal: $" + String.format("%.2f", theCartPrice));
        System.out.println("Tax (11.4%): $" + String.format("%.2f", theCartPrice * tax));
        System.out.println("How much would you like to tip? Enter the percent amount without the % [Ex. use '15' for test case purposes]");
        tip = promptValidDouble(scan)/100;
        if (theCartPrice > 0) {
        	finalPrice = theCartPrice + (theCartPrice * tip) + (theCartPrice * tax);
        }
        scan.close();   // Yi's edit
        return finalPrice;
    }

    private double promptValidDouble(Scanner scan) {
        while (!scan.hasNextDouble()) {
            System.out.println("Please enter a valid tip!");
            scan.next();
        }
        double tip = scan.nextDouble();
        if (tip < 0) {
            System.out.println("Please enter a positive tip!");
            tip = scan.nextDouble();
        }
        return tip;
    }
}
