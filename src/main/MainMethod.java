package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.UserCart;
import menu.MenuItem;

public class MainMethod {
	private Scanner mealChoice; 
    private UserCart cart;
    private ArrayList<MenuItem> menu;
    private static int largestPossibleInput;
    public MainMethod() {
    	mealChoice = new Scanner(System.in);
    	cart = new UserCart();
    	menu = new ArrayList<MenuItem>(); 
    	generateMenuItems(); 
    }
    
	public static void main(String args[]) {
		MainMethod foodItemMenu = new MainMethod();

		System.out.println("\nWelcome to EasyMeal!\n");
		foodItemMenu.printMenuItems();

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
    private void printMenuItems(){
    	System.out.println("Menu: "); 
    	for (MenuItem item: menu) {
    		System.out.println(item.getItemKey() + ". " + item.getItemName() + " $" + item.getItemPrice());
    	}
    	System.out.println("Press 0 to exit the menu.");
    }
	private void processOrder() {
		String yesOrNo;
		
		// choose menu
		System.out.println("Select menu item number:");
		largestPossibleInput = menu.size();
		int menuChoice = this.getUserIntInput();
		
		// choose quantity
		System.out.println("Select its quantity or 0 to exit the menu: ");
		largestPossibleInput = menu.get(menuChoice-1).getItemAmountInStock();
		int quantityChoice = this.getUserIntInput();

		if (quantityChoice > menu.get(quantityChoice).getItemAmountInStock()) {
			System.out.println("The item is out of stock.");
		}
		
		// print out order
		System.out.println(menu.get(menuChoice-1).getItemName() + ", " + "$" + menu.get(menuChoice-1).getItemPrice() + ", "
				+ (int) menu.get(menuChoice-1).getItemCalories() + " calories. " + quantityChoice + " unit(s) added to cart.");
		cart.addToCart(menu.get(menuChoice-1), quantityChoice);
		
		
		System.out.println("Would you like to order more food? (y/n): ");
		yesOrNo = getUserStringInputYesOrNo();  // this function make user enter inputs again if input is not string. 
		if (yesOrNo.equals("y")) {
			processOrder();
		} else if (yesOrNo.equals("n")) {
			System.out.println("Order total: $" + String.format("%.2f", cart.getFinalCartPrice()));
			
			System.out.println("Your order is processed.");
			
		}

	}
	public String getUserStringInputYesOrNo() {
		if (mealChoice.hasNextLine()) {
			String choice = mealChoice.next(); 
			if (!choice.equals("y") && !choice.equals("n")) {
				System.out.println("Please enter y or n");
				return getUserStringInputYesOrNo(); 
			}
			else {
				return choice; 
			}
		}
		else {
			System.out.println("Please enter a valid input");
			return getUserStringInputYesOrNo(); 
		}
	}
	public int getUserIntInput() {
		try {
			int choice = mealChoice.nextInt();
			if (choice == 0) {
				System.out.println("Leaving menu successful!");
				System.exit(0);
				return -1;
			} else if (choice > 0 && choice <= largestPossibleInput) {
				return choice; 
			} else {
				System.out.println("Please enter valid input");
				return getUserIntInput(); 
			}	
		}
		catch (InputMismatchException e) {
			System.out.println("Please enter an integer");
			mealChoice.next(); 
			return getUserIntInput(); 
		}
	}
}
