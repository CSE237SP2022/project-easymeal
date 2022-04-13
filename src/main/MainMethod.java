package main;

import java.util.ArrayList;
import java.util.Scanner;

import cart.UserCart;
import main.MenuClass;
import menu.MenuItem;

public class MainMethod {
	private Scanner mealChoice; 
    private UserCart cart;
    private ArrayList<MenuItem> menu;

    
    public MainMethod() {
    	mealChoice = new Scanner(System.in);
    	cart = new UserCart();
    	menu = new ArrayList<MenuItem>(); 
    	generateMenuItems(); 
    }
    
    
    
	public static void main(String args[]) {
		MainMethod foodItemMenu = new MainMethod();

		System.out.println("Welcome to EasyMeal!");
		System.out.println();
		foodItemMenu.printMenuItems();
		
		// scanner inputs:
		int choice ,quantity; 
		String yesOrNo; 
		// 
		
		System.out.println("Select menu item number:");
		choice = foodItemMenu.mealChoice.nextInt();
		System.out.println("Select its quantity: ");
		quantity = foodItemMenu.mealChoice.nextInt();
		foodItemMenu.processOrder(choice, quantity);
		
		System.out.println("Would you like to order more food? (y/n): "); 
		yesOrNo = foodItemMenu.mealChoice.next(); 
		if(yesOrNo.equals("y")) {
			System.out.println("Select menu item number:");
			choice = foodItemMenu.mealChoice.nextInt();
			System.out.println("Select its quantity: ");
			quantity = foodItemMenu.mealChoice.nextInt();
			foodItemMenu.processOrder(choice, quantity);
			
			System.out.println("Would you like to order more food? (y/n): "); 
			yesOrNo = foodItemMenu.mealChoice.next(); 
		}
		else if (yesOrNo.equals("n")) {
			System.out.println("Your order is processed."); 
		}
		else {
			System.out.println("Please enter y or n."); 
			yesOrNo = foodItemMenu.mealChoice.next(); 
		}
	}
   
    private void generateMenuItems(){
        MenuItem taco = new MenuItem(1, "Taco", 4.25, 153, 12);
        MenuItem pizza = new MenuItem(2, "Pizza", 5.25, 357, 6);
        MenuItem corn = new MenuItem(3, "Corn", 7.25, 97, 3);
        MenuItem salad = new MenuItem(4, "Salad", 5.71, 97, 3); 
        menu.add(taco);
        menu.add(pizza);
        menu.add(corn);
        menu.add(salad);
    }
    
    public void printMenuItems(){
    	System.out.println("Menu: "); 
    	for (MenuItem item: menu) {
    		System.out.println(item.getItemKey() + ". " + item.getItemName() + " $" + item.getItemPrice());
    	}
    	System.out.println("Press 0 to exit the menu."); 
    } 
	
    
    public void processOrder(int choice, int quantity){
    	System.out.println(menu.get(choice).getItemName()+", "
        		+ "$" + menu.get(choice).getItemPrice() + ", " 
        		+ (int) menu.get(choice).getItemCalories() + " calories. "
        		+ quantity + " unit(s) added to cart."); 
    	
    }
	
    
}
