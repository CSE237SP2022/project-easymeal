package main;

import java.util.ArrayList;
import java.util.Scanner;

import cart.UserCart;
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

		String yesOrNo; 
		// 
		

		foodItemMenu.processOrder();
		
		
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
	
    
	public void processOrder() {
		// scanner inputs:
		int choice, quantity;
		String yesOrNo;
		//
		
		
		// choose menu
		System.out.println("Select menu item number:");
		choice = mealChoice.nextInt();
		if (choice == 0) {
			
		}
		else if (choice >= 1 && choice <= menu.size()) {
			// choose quantity
			System.out.println("Select its quantity: ");
			quantity = mealChoice.nextInt();
			if (quantity > 0 && quantity <= menu.get(choice).getItemAmountInStock() ) {
				System.out.println(menu.get(choice).getItemName()+", "
		        		+ "$" + menu.get(choice).getItemPrice() + ", " 
		        		+ (int) menu.get(choice).getItemCalories() + " calories. "
		        		+ quantity + " unit(s) added to cart."); 
				System.out.println("Would you like to order more food? (y/n): "); 
				yesOrNo = mealChoice.next(); 
				if(yesOrNo.equals("y")) {
					processOrder();
				}
				else if (yesOrNo.equals("n")) {
					processTip();
					System.out.println("Your order is processed."); 
					
				}
				else {
					System.out.println("Please enter y or n."); 
					yesOrNo = mealChoice.next(); 
				}
			}
			else if(quantity > menu.get(choice).getItemAmountInStock()) {
				System.out.println("The item is out of stock."); 
			}
			else {
				System.out.println("Please enter a valid quantity"); 
			}
		}
		else {
			System.out.println("Please enter a valid menu item number"); 
		}
	
	}
	public void processTip() {
		String yesOrNoTip; 
		yesOrNoTip = mealChoice.nextLine(); 
		System.out.println("Would you like to add a tip? (y/n)"); 
		if(yesOrNoTip.equals("y")) {
			System.out.println("How much would you like to tip? [Ex. type '15' as 15%]");
			processOrder();
			System.out.println("Would you like to order more food? (y/n): "); 
			yesOrNoTip = mealChoice.nextLine(); 
		}
		else if (yesOrNoTip.equals("n")) {
			// tip function goes here.
			System.out.println("Your order is processed."); 
			
		}
		else {
			System.out.println("Please enter a valid input."); 
		}
	}
    
}
